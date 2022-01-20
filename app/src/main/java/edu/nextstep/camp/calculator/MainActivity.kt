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
        binding.button0.setOnClickListener { updateCalculateView(getString(R.string.calculator_0)) }
        binding.button1.setOnClickListener { updateCalculateView(getString(R.string.calculator_1)) }
        binding.button2.setOnClickListener { updateCalculateView(getString(R.string.calculator_2)) }
        binding.button3.setOnClickListener { updateCalculateView(getString(R.string.calculator_3)) }
        binding.button4.setOnClickListener { updateCalculateView(getString(R.string.calculator_4)) }
        binding.button5.setOnClickListener { updateCalculateView(getString(R.string.calculator_5)) }
        binding.button6.setOnClickListener { updateCalculateView(getString(R.string.calculator_6)) }
        binding.button7.setOnClickListener { updateCalculateView(getString(R.string.calculator_7)) }
        binding.button8.setOnClickListener { updateCalculateView(getString(R.string.calculator_8)) }
        binding.button9.setOnClickListener { updateCalculateView(getString(R.string.calculator_9)) }

        binding.buttonPlus.setOnClickListener { checkWithOperand(getString(R.string.calculator_plus)) }
        binding.buttonMinus.setOnClickListener { checkWithOperand(getString(R.string.calculator_minus)) }
        binding.buttonDivide.setOnClickListener { checkWithOperand(getString(R.string.calculator_divide)) }
        binding.buttonMultiply.setOnClickListener { checkWithOperand(getString(R.string.calculator_multiply)) }
        binding.buttonDelete.setOnClickListener { deleteStatement() }
        binding.buttonEquals.setOnClickListener { calculateStatement() }
    }

    private fun calculateStatement() {
        runCatching {
            binding.textView.text = expression.calculatedValue(binding.textView)
        }.getOrElse { e ->
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteStatement() {
        binding.textView.text = expression.deleteLastElement(binding.textView)
    }

    private fun updateCalculateView(input: String) {
        binding.textView.text = expression.appendOperand(binding.textView, input)
    }

    private fun checkWithOperand(operator: String) {
        if (binding.textView.text.isNotEmpty()) updateCalculateView(operator)
    }
}
