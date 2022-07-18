package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isOperator = false
    private var hasOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { clickOperand("0") }
        binding.button1.setOnClickListener { clickOperand("1") }
        binding.button2.setOnClickListener { clickOperand("2") }
        binding.button3.setOnClickListener { clickOperand("3") }
        binding.button4.setOnClickListener { clickOperand("4") }
        binding.button5.setOnClickListener { clickOperand("5") }
        binding.button6.setOnClickListener { clickOperand("6") }
        binding.button7.setOnClickListener { clickOperand("7") }
        binding.button8.setOnClickListener { clickOperand("8") }
        binding.button9.setOnClickListener { clickOperand("9") }

        binding.buttonPlus.setOnClickListener { clickOperator("+") }
        binding.buttonMinus.setOnClickListener { clickOperator("-") }
        binding.buttonMultiply.setOnClickListener { clickOperator("*") }
        binding.buttonDivide.setOnClickListener { clickOperator("/") }

        binding.buttonDelete.setOnClickListener { clickDelete() }
        binding.buttonEquals.setOnClickListener { clickEquals() }
    }

    private fun clickOperand(operand: String) {
        if (isOperator) {
            binding.textView.append(" ")
        }
        isOperator = false
        binding.textView.append(operand)
    }

    private fun clickOperator(operator: String) {
        if (binding.textView.text.isEmpty()) {
            return
        }
        if (isOperator) {
            binding.textView.text = binding.textView.text.toString().dropLast(1) + operator
            return
        }
        isOperator = true
        hasOperator = true
        binding.textView.append(" $operator")
    }

    private fun clickDelete() {
        if (binding.textView.text.isEmpty()) {
            return
        }
        val deleteSize = getDeleteSize(binding.textView.text.toString())
        binding.textView.text =
            binding.textView.text.substring(0, binding.textView.text.length - deleteSize)
    }

    private fun clickEquals() {
        val expressionTexts = binding.textView.text.split(" ")
        if (isCompletedExpression(expressionTexts)) {
            binding.textView.text = Calculator().calculate(expressionTexts).toString()
        }
    }

    private fun getDeleteSize(expressionTexts: String): Int {
        return if (expressionTexts[expressionTexts.lastIndex - 1] == ' ') {
            2
        } else {
            1
        }
    }

    private fun isCompletedExpression(expressionTexts: List<String>): Boolean {
        if (hasOperator.not() || expressionTexts.last().isNumber().not()) {
            Toast.makeText(this, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}

fun String.isNumber(): Boolean {
    return try {
        this.toBigInteger()
        true
    } catch (e: NumberFormatException) {
        false
    }
}
