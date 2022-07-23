package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.InputConverter
import edu.nextstep.camp.calculator.domain.Operand
import edu.nextstep.camp.calculator.domain.Operator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val inputConverter = InputConverter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        binding.button0.setOnClickListener { clickOp(resources.getString(R.string.calculator_0)) }
        binding.button1.setOnClickListener { clickOp(resources.getString(R.string.calculator_1)) }
        binding.button2.setOnClickListener { clickOp(resources.getString(R.string.calculator_2)) }
        binding.button3.setOnClickListener { clickOp(resources.getString(R.string.calculator_3)) }
        binding.button4.setOnClickListener { clickOp(resources.getString(R.string.calculator_4)) }
        binding.button5.setOnClickListener { clickOp(resources.getString(R.string.calculator_5)) }
        binding.button6.setOnClickListener { clickOp(resources.getString(R.string.calculator_6)) }
        binding.button7.setOnClickListener { clickOp(resources.getString(R.string.calculator_7)) }
        binding.button8.setOnClickListener { clickOp(resources.getString(R.string.calculator_8)) }
        binding.button9.setOnClickListener { clickOp(resources.getString(R.string.calculator_9)) }
        binding.buttonPlus.setOnClickListener { clickOp(resources.getString(R.string.calculator_plus)) }
        binding.buttonMinus.setOnClickListener { clickOp(resources.getString(R.string.calculator_minus)) }
        binding.buttonMultiply.setOnClickListener { clickOp(resources.getString(R.string.calculator_multiply)) }
        binding.buttonDivide.setOnClickListener { clickOp(resources.getString(R.string.calculator_divide)) }
        binding.buttonDelete.setOnClickListener { clickDelete() }
        binding.buttonEquals.setOnClickListener {
            runCatching { Calculator().evaluate(inputConverter.token) }
                .onSuccess { result ->
                    binding.textView.text = result.toString()
                    inputConverter.clearAndAddResult(result)
                }
                .onFailure {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.unfinished_formula),
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }

    private fun clickOp(op: String) {
        inputConverter.add(op)
        updateTextView()
    }

    private fun clickDelete() {
        inputConverter.delete()
        updateTextView()
    }

    private fun updateTextView() {
        binding.textView.text = inputConverter.token.joinToString(separator = " ") { token ->
            when (token) {
                is Operand -> token.operand.toString()
                is Operator -> token.symbol
            }
        }
    }
}
