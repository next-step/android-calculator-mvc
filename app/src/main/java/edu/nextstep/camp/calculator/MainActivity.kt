package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.Operation
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var viewState by Delegates.observable(MainState.DisplayText("")) { _, _, newValue ->
        onViewState(newValue)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initializeLayout()
    }

    private fun initializeLayout() {
        setContentView(binding.root)
        binding.button0.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 0)) }
        binding.button1.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 1)) }
        binding.button2.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 2)) }
        binding.button3.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 3)) }
        binding.button4.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 4)) }
        binding.button5.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 5)) }
        binding.button6.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 6)) }
        binding.button7.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 7)) }
        binding.button8.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 8)) }
        binding.button9.setOnClickListener { onEvent(MainEvent.AddNumber("${binding.textView.text}", 9)) }
        binding.buttonDelete.setOnClickListener { onEvent(MainEvent.DeleteLast("${binding.textView.text}")) }
        binding.buttonDivide.setOnClickListener { onEvent(MainEvent.AddOperator("${binding.textView.text}", Operation.Div.operator)) }
        binding.buttonPlus.setOnClickListener { onEvent(MainEvent.AddOperator("${binding.textView.text}", Operation.Plus.operator)) }
        binding.buttonMinus.setOnClickListener { onEvent(MainEvent.AddOperator("${binding.textView.text}", Operation.Minus.operator)) }
        binding.buttonMultiply.setOnClickListener { onEvent(MainEvent.AddOperator("${binding.textView.text}", Operation.Mult.operator)) }
        binding.buttonEquals.setOnClickListener { onEvent(MainEvent.Evalute("${binding.textView.text}")) }
    }

    //ui update
    private fun onViewState(state: MainState) = when(state) {
        is MainState.DisplayText -> binding.textView.text = state.displayText
    }

    //logic
    private fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.DeleteLast -> eventDeleteLast(event)
            is MainEvent.AddOperator -> eventAddOperator(event)
            is MainEvent.AddNumber -> eventAddNumber(event)
            is MainEvent.Evalute -> eventEvalute(event)
        }
    }

    private fun eventDeleteLast(event: MainEvent.DeleteLast) {
        val text = getLastDeletedText(event.displayedText)
        viewState = MainState.DisplayText(text)
    }

    private fun getLastDeletedText(displayedText: String) = displayedText
        .dropLastWhile { it == ' ' || it == '.' }
        .dropLast(1)
        .dropLastWhile { it == ' ' || it == '.' }

    private fun eventAddOperator(event: MainEvent.AddOperator) {
        val lastChar = getTextViewLastChar(event.displayedText) ?: return
        val displayedText = when(lastChar.isDigit()) {
            true -> event.displayedText
            false -> getLastDeletedText(event.displayedText)
        }

        val text = "$displayedText ${event.operator}"
        viewState = MainState.DisplayText(text)
    }

    private fun eventEvalute(event: MainEvent.Evalute) {
        runCatching {
            Calculator().evalute(event.displayedText)
        }.onSuccess {
            viewState = MainState.DisplayText(getDisplayTextByEvalute(it))
        }.onFailure {
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDisplayTextByEvalute(computed: Double): String = when(computed - computed.toInt()) {
        0.0 -> "${computed.toInt()}"
        else -> "$computed"
    }

    private fun eventAddNumber(event: MainEvent.AddNumber) {
        viewState = MainState.DisplayText(getDisplayTextByAddNumber(event, event.displayedText))
    }

    private fun getDisplayTextByAddNumber(
        event: MainEvent.AddNumber,
        displayedText: CharSequence
    ) : String {
        val lastChar: Char? = getTextViewLastChar(displayedText)
        return when {
            displayedText == "0" -> "${event.num}"
            lastChar == null -> "${event.num}"
            lastChar.isDigit() -> "$displayedText${event.num}"
            lastChar == ' ' -> "$displayedText${event.num}"
            else -> "$displayedText ${event.num}"
        }
    }

    private fun getTextViewLastChar(
        text: CharSequence
    ) = text.getOrNull(text.lastIndex)
}
