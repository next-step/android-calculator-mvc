package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.domain.CalculatorInterface
import edu.nextstep.camp.domain.exception.InvalidExpressionException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculatorInterface = CalculatorInterface()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set Button Numbers
        binding.button0.setOnClickListener { updateDisplay(calculatorInterface.insert("0")) }
        binding.button1.setOnClickListener { updateDisplay(calculatorInterface.insert("1")) }
        binding.button2.setOnClickListener { updateDisplay(calculatorInterface.insert("2")) }
        binding.button3.setOnClickListener { updateDisplay(calculatorInterface.insert("3")) }
        binding.button4.setOnClickListener { updateDisplay(calculatorInterface.insert("4")) }
        binding.button5.setOnClickListener { updateDisplay(calculatorInterface.insert("5")) }
        binding.button6.setOnClickListener { updateDisplay(calculatorInterface.insert("6")) }
        binding.button7.setOnClickListener { updateDisplay(calculatorInterface.insert("7")) }
        binding.button8.setOnClickListener { updateDisplay(calculatorInterface.insert("8")) }
        binding.button9.setOnClickListener { updateDisplay(calculatorInterface.insert("9")) }

        // set Button Operators
        binding.buttonPlus.setOnClickListener { updateDisplay(calculatorInterface.insert("+")) }
        binding.buttonMinus.setOnClickListener { updateDisplay(calculatorInterface.insert("-")) }
        binding.buttonMultiply.setOnClickListener { updateDisplay(calculatorInterface.insert("×")) }
        binding.buttonDivide.setOnClickListener { updateDisplay(calculatorInterface.insert("÷")) }

        // set Button Equals
        binding.buttonEquals.setOnClickListener { updateDisplay(calculatorInterface.evaluate()) }

        // set Button Delete
        binding.buttonDelete.setOnClickListener { updateDisplay(calculatorInterface.delete()) }
    }

    private fun updateDisplay(result: Result<String>) {
        result
            .onSuccess { binding.textView.text = it }
            .onFailure {
                when(it) {
                is InvalidExpressionException -> Toast.makeText(this, getString(R.string.error_invalid_expression),
                    Toast.LENGTH_SHORT).show()
                }
            }
    }
}
