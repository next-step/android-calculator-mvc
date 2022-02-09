package edu.nextstep.camp.calculator

import android.os.Bundle
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
    private lateinit var binding: ActivityMainBinding
    private val expression = ExpressionBuffer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resultTextView = binding.textView
        setUpOperandButton()
        setUpOperatorButton()
        binding.buttonDelete.setOnClickListener { onDeleteClick() }
        binding.buttonEquals.setOnClickListener { onResultClick() }
    }

    private fun setUpOperandButton() = with(binding) {
        button0.setOnClickListener { onOperandClick(button0.text.toString()) }
        button1.setOnClickListener { onOperandClick(button1.text.toString()) }
        button2.setOnClickListener { onOperandClick(button2.text.toString()) }
        button3.setOnClickListener { onOperandClick(button3.text.toString()) }
        button4.setOnClickListener { onOperandClick(button4.text.toString()) }
        button5.setOnClickListener { onOperandClick(button5.text.toString()) }
        button6.setOnClickListener { onOperandClick(button6.text.toString()) }
        button7.setOnClickListener { onOperandClick(button7.text.toString()) }
        button8.setOnClickListener { onOperandClick(button8.text.toString()) }
        button9.setOnClickListener { onOperandClick(button9.text.toString()) }
    }

    private fun onOperandClick(value: String) {
        val operand = Operand(value)
        val currentExpression = expression.addOperand(operand)
        refreshResultText(currentExpression)
    }

    private fun setUpOperatorButton() = with(binding) {
        buttonPlus.setOnClickListener { onOperatorClick(buttonPlus.text.toString()) }
        buttonMinus.setOnClickListener { onOperatorClick(buttonMinus.text.toString()) }
        buttonMultiply.setOnClickListener { onOperatorClick(buttonMultiply.text.toString()) }
        buttonDivide.setOnClickListener { onOperatorClick(buttonDivide.text.toString()) }
    }

    private fun onOperatorClick(symbol: String) {
        val operator = Operator.findOperatorBySymbol(symbol)
        val currentExpression = expression.addOperator(operator)
        refreshResultText(currentExpression)
    }

    private fun onDeleteClick() {
        val currentExpression = expression.removeLast()
        refreshResultText(currentExpression)
    }

    private fun onResultClick() {
        val expression = expression.getStringExpression()
        Calculator.runCatching { calculate(expression) }
            .onSuccess { result -> refreshResultText(result.toString()) }
            .onFailure { Toast.makeText(this, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show() }
    }

    private fun refreshResultText(value: String) {
        resultTextView.text = value
    }
}
