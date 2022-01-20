package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val expression by lazy { Expression() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickButtonListener()
    }

    private fun clickButtonListener() {
        binding.button0.setOnClickListener { appendOperand(getString(R.string.calculator_0)) }
        binding.button1.setOnClickListener { appendOperand(getString(R.string.calculator_1)) }
        binding.button2.setOnClickListener { appendOperand(getString(R.string.calculator_2)) }
        binding.button3.setOnClickListener { appendOperand(getString(R.string.calculator_3)) }
        binding.button4.setOnClickListener { appendOperand(getString(R.string.calculator_4)) }
        binding.button5.setOnClickListener { appendOperand(getString(R.string.calculator_5)) }
        binding.button6.setOnClickListener { appendOperand(getString(R.string.calculator_6)) }
        binding.button7.setOnClickListener { appendOperand(getString(R.string.calculator_7)) }
        binding.button8.setOnClickListener { appendOperand(getString(R.string.calculator_8)) }
        binding.button9.setOnClickListener { appendOperand(getString(R.string.calculator_9)) }

        binding.buttonPlus.setOnClickListener { appendOperator(getString(R.string.calculator_plus)) }
        binding.buttonMinus.setOnClickListener { appendOperator(getString(R.string.calculator_minus)) }
        binding.buttonDivide.setOnClickListener { appendOperator(getString(R.string.calculator_divide)) }
        binding.buttonMultiply.setOnClickListener { appendOperator(getString(R.string.calculator_multiply)) }
        binding.buttonDelete.setOnClickListener { deleteLastElement() }
        binding.buttonEquals.setOnClickListener { calculateStatement() }
    }
    private fun appendOperand(operand: String) {
        binding.textView.text = expression.appendStatement(binding.textView, operand)
    }

    private fun appendOperator(operator: String) {
        if (binding.textView.text.isNotEmpty()) {
            binding.textView.text = expression.appendStatement(binding.textView, operator)
        }
    }

    private fun deleteLastElement() {
        binding.textView.text = expression.deleteLastElement(binding.textView)
    }

    private fun calculateStatement() {
        runCatching {
            binding.textView.text = expression.calculatedValue(binding.textView)
        }.onFailure { e ->
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}
