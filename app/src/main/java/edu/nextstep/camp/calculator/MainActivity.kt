package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.camp.calculator.Calculator
import edu.nextstep.camp.calculator.domain.camp.calculator.Operation
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
        binding.buttonEquals.setOnClickListener { onEvent(MainEvent.Evaluate("${binding.textView.text}")) }
    }

    // UI Update
    private fun onViewState(state: MainState) = when(state) {
        is MainState.DisplayText -> binding.textView.text = state.displayText
    }

    // Logic
    private fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.DeleteLast -> eventDeleteLast(event)
            is MainEvent.AddOperator -> eventAddOperator(event)
            is MainEvent.AddNumber -> eventAddNumber(event)
            is MainEvent.Evaluate -> eventEvaluate(event)
        }
    }

    private fun eventDeleteLast(event: MainEvent.DeleteLast) {
        val text = deleteLastOperatorOrNumber(event.displayedText)
        viewState = MainState.DisplayText(text)
        binding.button0.setOnClickListener { binding.textView.text = "0" }
        binding.button1.setOnClickListener { binding.textView.text = "1" }
        binding.button2.setOnClickListener { binding.textView.text = "2" }
        binding.button3.setOnClickListener { binding.textView.text = "3" }
        binding.button4.setOnClickListener { binding.textView.text = "4" }
        binding.button5.setOnClickListener { binding.textView.text = "5" }
        binding.button6.setOnClickListener { binding.textView.text = "6" }
        binding.button7.setOnClickListener { binding.textView.text = "7" }
        binding.button8.setOnClickListener { binding.textView.text = "8" }
        binding.button9.setOnClickListener { binding.textView.text = "9" }
    }

    private fun deleteLastOperatorOrNumber(displayText: String) = displayText
        .dropLastWhile { it == ' ' || it == '.' }
        .dropLast(1)
        .dropLastWhile { it == ' ' || it == '.' }

    private fun eventAddOperator(event: MainEvent.AddOperator) {
        val lastChar = event.displayedText.getOrNull(event.displayedText.lastIndex) ?: return
        val displayedText = when(lastChar.isDigit()) {
            true -> event.displayedText
            false -> deleteLastOperatorOrNumber(event.displayedText)
        }

        val text = "$displayedText ${event.operator}"
        viewState = MainState.DisplayText(text)
    }

    private fun eventEvaluate(event: MainEvent.Evaluate) {
        runCatching {
            Calculator().evaluate(event.displayedText)
        }.onSuccess {
            viewState = MainState.DisplayText(getEvaluateDisplayText(it))
        }.onFailure {
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getEvaluateDisplayText(computed: Double): String = when(computed - computed.toInt()) {
        0.0 -> "${computed.toInt()}"
        else -> "$computed"
    }

    private fun eventAddNumber(event: MainEvent.AddNumber) {
        viewState = MainState.DisplayText(getNumberAddedDisplayText(event, event.displayedText))
    }

    private fun getNumberAddedDisplayText(
        event: MainEvent.AddNumber,
        displayText: CharSequence
    ): String {
        val lastChar: Char? = displayText.getOrNull(displayText.lastIndex)
        return when {
            displayText == "0" -> "${event.num}"
            lastChar == null -> "${event.num}"
            lastChar.isDigit() -> "$displayText${event.num}"
            lastChar == ' ' -> "$displayText${event.num}"
            else -> "$displayText ${event.num}"
        }
    }

}
