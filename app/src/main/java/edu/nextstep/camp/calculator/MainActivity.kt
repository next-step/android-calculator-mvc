package edu.nextstep.camp.calculator

import CalculatorInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import exception.EvaluateExpressionException
import exception.InvalidExpressionException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val calculatorInterface = CalculatorInterface()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
    }

    private fun setupUi() {
        setupButtonNumbers()
        setupButtonOperators()
        setupButtonDelete()
        setupButtonEquals()
    }

    private fun setupButtonNumbers() {
        val buttonNumbers = listOf(
            binding.button0, binding.button1, binding.button2, binding.button3, binding.button4,
            binding.button5, binding.button6, binding.button7, binding.button8, binding.button9
        )

        buttonNumbers.forEach(::setButtonNumbersClickListener)
    }

    private fun setButtonNumbersClickListener(button: Button) {
        button.setOnClickListener {
            updateDisplay(calculatorInterface.insert(button.text.toString()))
        }
    }

    private fun setupButtonOperators() {
        binding.buttonPlus.setOnClickListener {
            updateDisplay(calculatorInterface.insert("+"))
        }

        binding.buttonMinus.setOnClickListener {
            updateDisplay(calculatorInterface.insert("-"))
        }

        binding.buttonMultiply.setOnClickListener {
            updateDisplay(calculatorInterface.insert("×"))
        }

        binding.buttonDivide.setOnClickListener {
            updateDisplay(calculatorInterface.insert("÷"))
        }
    }

    private fun setupButtonDelete() {
        binding.buttonDelete.setOnClickListener {
            updateDisplay(calculatorInterface.delete())
        }
    }

    private fun setupButtonEquals() {
        binding.buttonEquals.setOnClickListener {
            updateDisplay(calculatorInterface.evaluate())
        }
    }

    private fun updateDisplay(result: Result<String>) {
        result
            .onSuccess { updateDisplayOnSuccess(result.getOrNull()) }
            .onFailure { updateDisplayOnFailure(result.exceptionOrNull()) }
    }

    private fun updateDisplayOnSuccess(value: String?) {
        binding.tvResultDisplay.text = value ?: return
    }

    private fun updateDisplayOnFailure(throwable: Throwable?) {
        when (throwable) {
            is InvalidExpressionException -> Toast.makeText(this, getString(R.string.error_invalid_expression), Toast.LENGTH_SHORT).show()
            is EvaluateExpressionException -> Toast.makeText(this, getString(R.string.error_evaluate_expression), Toast.LENGTH_SHORT).show()
        }
    }

}
