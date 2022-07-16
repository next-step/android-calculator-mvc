package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Operand
import edu.nextstep.camp.calculator.domain.Operator
import edu.nextstep.camp.calculator.domain.StringCalculator
import edu.nextstep.camp.calculator.domain.StringExpression


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val stringExpression: StringExpression
        get() = StringExpression(binding.textView.text.toString())

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
            val viewId = resources.getIdentifier("$BUTTON_VIEW_PREFIX$number", "id", packageName)
            val button = findViewById(viewId) as? Button ?: return@forEach
            setOperandButtonListener(button, Operand(number))
        }
    }

    private fun setOperandButtonListener(button: Button, operand: Operand) {
        button.setOnClickListener {
            binding.textView.text = stringExpression.plusElement(operand).value
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
            binding.textView.text = stringExpression.plusElement(operator).value
        }
    }

    private fun initDeleteButton() {
        binding.buttonDelete.setOnClickListener {
            binding.textView.text = stringExpression.minusElement().value
        }
    }

    private fun initEqualsButton() {
        binding.buttonEquals.setOnClickListener {
            try {
                binding.textView.text = StringCalculator
                    .calculate(stringExpression)
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
        private const val BUTTON_VIEW_PREFIX = "button"
    }
}
