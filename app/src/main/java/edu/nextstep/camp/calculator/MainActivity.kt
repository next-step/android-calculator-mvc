package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator: Calculator = Calculator(DELIMITER)

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
        calculator.addOperand(number)
        updateText()
    }

    private fun onClickOperator(operator: String) {
        calculator.addOperator(operator)
        updateText()
    }

    private fun onClickDelete() {
        calculator.delete()
        updateText()
    }

    private fun onClickEquals() {
        calculator.evaluate {
            Toast.makeText(this, getText(R.string.not_completed_expression), Toast.LENGTH_SHORT)
                .show()
        }
        updateText()
    }

    private fun updateText() {
        binding.textView.text = calculator.expression
    }

    companion object {
        private const val DELIMITER = ' '
    }
}
