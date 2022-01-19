package edu.nextstep.camp.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.nextstep.domain.Calculator
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator by lazy { Calculator() }

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
            binding.textView.text = calculator.calculate(replaceOperator()).toString()
        }.getOrElse { e ->
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun replaceOperator(): String {
        return binding.textView.text.toString()
            .replace(getString(R.string.calculator_divide), getString(R.string.operator_divide))
            .replace(getString(R.string.calculator_multiply), getString(R.string.operator_multiply))
    }

    private fun deleteStatement() {
        binding.textView.text = binding.textView.text.toString().dropLast(1).trim()
    }

    private fun updateCalculateView(input: String) {
        val baseStatement = binding.textView.text.toString().trim()
        binding.textView.text = baseStatement.addOperandToNumber(input)
    }

    @SuppressLint("SetTextI18n")
    private fun String.addOperandToNumber(input: String): String {
        val baseStatement = this@addOperandToNumber
        return if (
            baseStatement.isEmpty() ||
            (baseStatement.last().isDigit() && input.isDigitsOnly())
        ) {
            baseStatement + input
        } else {
            "$baseStatement $input"
        }
    }

    private fun checkWithOperand(operator: String) {
        if (binding.textView.text.isEmpty()) return
        else updateCalculateView(operator)
    }
}
