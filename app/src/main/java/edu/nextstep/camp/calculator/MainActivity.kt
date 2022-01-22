package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.Calculator.Result
import edu.nextstep.camp.calculator.domain.Calculator.Result.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
    }

    private fun setupUi() {
        val buttons = listOf(
            binding.button0, binding.button1, binding.button2, binding.button3, binding.button4,
            binding.button5, binding.button6, binding.button7, binding.button8, binding.button9,
            binding.buttonPlus, binding.buttonMinus, binding.buttonMultiply, binding.buttonDivide
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                Calculator.insert(button.text.toString())
                updateDisplay()
            }
        }

        binding.buttonDelete.setOnClickListener {
            Calculator.delete()
            updateDisplay()
        }

        binding.buttonEquals.setOnClickListener {
            Calculator.evaluate()
            updateDisplay()
        }
    }

    private fun updateDisplay() {
        when (val result = Calculator.result()) {
            is Success -> binding.tvResultDisplay.text = result.value
            is Failure -> Toast.makeText(this, getString(R.string.error_incomplete_expression), Toast.LENGTH_SHORT).show()
        }
    }
}
