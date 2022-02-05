package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.StringCalculator
import edu.nextstep.camp.calculator.model.formular.Formula

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val formula: Formula = Formula()

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
        binding.textViewDisplay.text = formula.delete()
    }

    private fun clickOperand(value: String) {
        binding.textViewDisplay.text = formula.insertOperand(value)
    }

    private fun clickOperator(value: String) {
        binding.textViewDisplay.text = formula.insertOperator(value)
    }

    private fun calculator() {
        try {
            binding.textViewDisplay.text = "${StringCalculator().calculate(formula.toString()).toInt()}"
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, R.string.err_invalid_formula, Toast.LENGTH_SHORT).show()
        }
    }
}
