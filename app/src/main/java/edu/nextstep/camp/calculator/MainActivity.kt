package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import jinsu.antilog.domain.Calculator
import jinsu.antilog.domain.ExpressionBuffer
import jinsu.antilog.domain.Operand
import jinsu.antilog.domain.Operator

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private val expression = ExpressionBuffer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            resultTextView = textView
            setUpOperandButton(
                button0,
                button1,
                button2,
                button3,
                button4,
                button5,
                button6,
                button7,
                button8,
                button9
            )
            setUpOperatorButton(
                buttonPlus,
                buttonMinus,
                buttonMultiply,
                buttonDivide
            )
            buttonDelete.setOnClickListener { onClickDelete() }
            buttonEquals.setOnClickListener { onClickResult() }
        }.also { setContentView(it.root) }
    }

    private fun setUpOperandButton(vararg operandButtons: Button) {
        operandButtons.forEach { button ->
            button.setOnClickListener { onClickOperand(button.text.toString()) }
        }
    }

    private fun onClickOperand(value: String) {
        val operand = Operand(value)
        val currentExpression = expression.addOperand(operand)
        refreshResultText(currentExpression)
    }

    private fun setUpOperatorButton(vararg operatorButtons: Button) {
        operatorButtons.forEach { button ->
            button.setOnClickListener { onClickOperator(button.text.toString()) }
        }
    }

    private fun onClickOperator(symbol: String) {
        val operator = Operator.findOperatorBySymbol(symbol)
        val currentExpression = expression.addOperator(operator)
        refreshResultText(currentExpression)
    }

    private fun onClickDelete() {
        val currentExpression = expression.removeLast()
        refreshResultText(currentExpression)
    }

    private fun onClickResult() {
        Calculator.runCatching { calculate(expression.getStringExpression()) }
            .onSuccess { result ->
                refreshResultText(result.toString())
            }.onFailure { Toast.makeText(this, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show() }
    }

    private fun refreshResultText(value: String) {
        resultTextView.text = value
    }
}
