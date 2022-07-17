package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val expressionStack = Stack<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { onClickOperand("0") }
        binding.button1.setOnClickListener { onClickOperand("1") }
        binding.button2.setOnClickListener { onClickOperand("2") }
        binding.button3.setOnClickListener { onClickOperand("3") }
        binding.button4.setOnClickListener { onClickOperand("4") }
        binding.button5.setOnClickListener { onClickOperand("5") }
        binding.button6.setOnClickListener { onClickOperand("6") }
        binding.button7.setOnClickListener { onClickOperand("7") }
        binding.button8.setOnClickListener { onClickOperand("8") }
        binding.button9.setOnClickListener { onClickOperand("9") }

        binding.buttonPlus.setOnClickListener { onClickOperator("+") }
        binding.buttonMinus.setOnClickListener { onClickOperator("-") }
        binding.buttonDivide.setOnClickListener { onClickOperator("/") }
        binding.buttonMultiply.setOnClickListener { onClickOperator("*") }

        binding.buttonDelete.setOnClickListener { onClickDelete() }
        binding.buttonEquals.setOnClickListener { onClickEquals() }
    }

    private fun onClickOperand(number: String) {
        if (expressionStack.isNotEmpty() && expressionStack.last().isDigitsOnly()) {
            expressionStack.push(expressionStack.pop() + number)
        } else {
            expressionStack.push(number)
        }
        updateText()
    }

    private fun onClickOperator(operator: String) {
        if (expressionStack.isEmpty()) return

        if (!expressionStack.last().isDigitsOnly()) {
            expressionStack.pop()
        }
        expressionStack.push(operator)
        updateText()
    }

    private fun onClickDelete() {
        if (expressionStack.isEmpty()) return
        val value = expressionStack.pop()
        if (value.isDigitsOnly() && value.toInt() >= 10) {
            expressionStack.push(value.dropLast(1))
        }
        updateText()
    }

    private fun onClickEquals() {
        if (expressionStack.isEmpty() || !expressionStack.last().isDigitsOnly()) {
            Toast.makeText(this, getText(R.string.not_completed_expression), Toast.LENGTH_SHORT)
                .show()
            return
        }
        binding.textView.text =
            Calculator(DELIMITER).evaluate(expressionStack.joinToString(DELIMITER.toString()))
                .toString()
    }

    private fun updateText() {
        binding.textView.text = expressionStack.joinToString(DELIMITER.toString())
    }

    companion object {
        private const val DELIMITER = ' '
    }
}
