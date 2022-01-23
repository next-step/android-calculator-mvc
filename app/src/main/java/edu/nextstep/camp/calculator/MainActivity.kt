package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val calculator = Calculator()

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

        buttons.forEach(::setupButtonsClickListener)

        binding.buttonDelete.setOnClickListener {
            calculator.delete()
            updateDisplay()
        }

        binding.buttonEquals.setOnClickListener {
            calculator.evaluate()
            updateDisplay()
        }
    }

    private fun setupButtonsClickListener(button: Button) {
        button.setOnClickListener {
            calculator.insert(button.text.toString())
            updateDisplay()
        }
    }

    private fun updateDisplay() {
        val result = calculator.result ?: return

        when (result.isSuccess) {
            true -> binding.tvResultDisplay.text = result.getOrThrow()
            false -> Toast.makeText(this, getString(R.string.error_incomplete_expression), Toast.LENGTH_SHORT).show()
        }
    }
}
