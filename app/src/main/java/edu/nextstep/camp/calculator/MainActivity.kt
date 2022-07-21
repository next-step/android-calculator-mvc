package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calculator: Calculator
    private lateinit var expression: Expression

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculator = Calculator()
        expression = Expression()
        setViewClickListener()
    }

    private fun setViewClickListener() {
        binding.button0.setOnClickListener { addNumber("0") }
        binding.button1.setOnClickListener { addNumber("1") }
        binding.button2.setOnClickListener { addNumber("2") }
        binding.button3.setOnClickListener { addNumber("3") }
        binding.button4.setOnClickListener { addNumber("4") }
        binding.button5.setOnClickListener { addNumber("5") }
        binding.button6.setOnClickListener { addNumber("6") }
        binding.button7.setOnClickListener { addNumber("7") }
        binding.button8.setOnClickListener { addNumber("8") }
        binding.button9.setOnClickListener { addNumber("9") }
        binding.buttonDivide.setOnClickListener { addOperator(" / ") }
        binding.buttonMinus.setOnClickListener { addOperator(" - ") }
        binding.buttonMultiply.setOnClickListener { addOperator(" * ") }
        binding.buttonPlus.setOnClickListener { addOperator(" + ") }
        binding.buttonEquals.setOnClickListener { calculateString() }
        binding.buttonDelete.setOnClickListener { deleteInputString() }
    }

    private fun addNumber(text: String) {
        val expression = binding.tvResult.text
        binding.tvResult.text = "$expression$text"
    }

    private fun addOperator(text: String) {
        val expression = binding.tvResult.text
        if (expression.isEmpty()) {
            return
        }
        binding.tvResult.text = "$expression$text"
    }

    private fun calculateString() {
        val inputs = binding.tvResult.text.toString()
        try {
            expression.setStackForCalculating(inputs)
            binding.tvResult.text = calculator.evaluate(expression).toString()
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteInputString() {
        val lastValue = binding.tvResult.text.last()
        if (lastValue.digitToIntOrNull() == null) {
            deleteOperator()
        } else {
            deleteNumber()
        }
    }

    private fun deleteNumber() {
        binding.tvResult.text = binding.tvResult.text.dropLast(1)
    }

    private fun deleteOperator() {
        binding.tvResult.text = binding.tvResult.text.dropLast(3)
    }

    companion object {
        const val ERROR_MESSAGE = "완성되지 않은 수식입니다"
    }
}
