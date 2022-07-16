package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Operator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val displayedText: String
        get() = binding.textView.text.toString()

    private val buttonToOperator: Map<Button, Operator> by lazy {
        mapOf(
            binding.buttonPlus to Operator.PLUS,
            binding.buttonMinus to Operator.MINUS,
            binding.buttonMultiply to Operator.MULTIPLY,
            binding.buttonDivide to Operator.DIVIDE,
        )
    }

    private val Operator.displayedValue: String
        get() = when (this) {
            Operator.MULTIPLY -> "×"
            Operator.DIVIDE -> "÷"
            else -> symbol
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewBinding()
        initOperandButtons()
        initOperatorButtons()
        initDeleteButton()
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initOperandButtons() {
        (0..9).forEach { number ->
            val viewId = resources.getIdentifier("button$number", "id", packageName)
            val button = findViewById(viewId) as? Button ?: return@forEach
            setOperandButtonListener(button, number)
        }
    }

    private fun setOperandButtonListener(button: Button, number: Int) {
        button.setOnClickListener {
            val shouldAddSpace =
                displayedText.lastOrNull() != null && !displayedText.last().isDigit()
            val text = displayedText + if (shouldAddSpace) "$SPACE$number" else number
            binding.textView.text = text
        }
    }

    private fun initOperatorButtons() {
        listOf(
            binding.buttonPlus,
            binding.buttonMinus,
            binding.buttonMultiply,
            binding.buttonDivide,
        ).forEach {
            setOperatorButtonListener(
                button = it,
                operator = buttonToOperator[it]
                    ?: throw IllegalArgumentException("지원되지 않는 형식의 Operator입니다.")
            )
        }
    }

    private fun setOperatorButtonListener(button: Button, operator: Operator) {
        button.setOnClickListener {
            if (displayedText.isEmpty()) return@setOnClickListener
            val text = displayedText + "$SPACE${operator.displayedValue}"
            binding.textView.text = text
        }
    }

    private fun initDeleteButton() {
        binding.buttonDelete.setOnClickListener {
            if (displayedText.isEmpty()) return@setOnClickListener
            binding.textView.text = displayedText
                .dropLast(CHARACTER_DELETE_UNIT)
                .trim()
        }
    }

    companion object {
        private const val SPACE = " "
        private const val CHARACTER_DELETE_UNIT = 1
    }
}
