package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.calculator.StringCalculator
import edu.nextstep.camp.calculator.domain.expression.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var expression: Expression = Expression()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnclickListener()
    }


    private fun setOnclickListener() {
        binding.button0.setOnClickListener { clickOperand("0") }
        binding.button1.setOnClickListener { clickOperand("1") }
        binding.button2.setOnClickListener { clickOperand("2") }
        binding.button3.setOnClickListener { clickOperand("3") }
        binding.button4.setOnClickListener { clickOperand("4") }
        binding.button5.setOnClickListener { clickOperand("5") }
        binding.button6.setOnClickListener { clickOperand("6") }
        binding.button7.setOnClickListener { clickOperand("7") }
        binding.button8.setOnClickListener { clickOperand("8") }
        binding.button9.setOnClickListener { clickOperand("9") }
        binding.buttonPlus.setOnClickListener { clickOperator("+") }
        binding.buttonMinus.setOnClickListener { clickOperator("-") }
        binding.buttonDivide.setOnClickListener { clickOperator("/") }
        binding.buttonMultiply.setOnClickListener { clickOperator("*") }
        binding.buttonEquals.setOnClickListener { calculator() }
        binding.buttonDelete.setOnClickListener { delete() }
    }

    private fun delete() {
        binding.textViewDisplay.text = expression.delete()
    }

    private fun clickOperand(value: String) {
        binding.textViewDisplay.text = expression.insertOperand(value)
    }

    private fun clickOperator(value: String) {
        binding.textViewDisplay.text = expression.insertOperator(value)
    }

    private fun calculator() {
        try {
            expression = StringCalculator().calculate(expression)
            binding.textViewDisplay.text = "$expression"
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, R.string.err_invalid_formula, Toast.LENGTH_SHORT).show()
        }
    }
}
