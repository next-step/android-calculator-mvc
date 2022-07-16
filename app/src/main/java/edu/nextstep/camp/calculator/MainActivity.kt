package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Operator
import edu.nextstep.camp.calculator.domain.StringCalculator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val displayedText: String
        get() = binding.textView.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewBinding()
        initOperandButtons()
        initOperatorButtons()
        initDeleteButton()
        initEqualsButton()
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
            binding.buttonPlus to Operator.PLUS,
            binding.buttonMinus to Operator.MINUS,
            binding.buttonMultiply to Operator.MULTIPLY,
            binding.buttonDivide to Operator.DIVIDE,
        ).forEach { (button, operator) ->
            setOperatorButtonListener(
                button = button,
                operator = operator
            )
        }
    }

    private fun setOperatorButtonListener(button: Button, operator: Operator) {
        button.setOnClickListener {
            if (displayedText.isEmpty()) return@setOnClickListener
            val text = displayedText + "$SPACE${operator.symbol}"
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

    private fun initEqualsButton() {
        binding.buttonEquals.setOnClickListener {
            try {
                binding.textView.text = StringCalculator
                    .calculate(displayedText)
                    .value
                    .toString()
            } catch (e: IllegalArgumentException) {
                Toast
                    .makeText(this, R.string.illegal_expression_toast, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    companion object {
        private const val SPACE = " "
        private const val CHARACTER_DELETE_UNIT = 1
    }
}
