package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val expression = Expression()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        binding.button0.setOnClickListener { clickToken(resources.getString(R.string.calculator_0)) }
        binding.button1.setOnClickListener { clickToken(resources.getString(R.string.calculator_1)) }
        binding.button2.setOnClickListener { clickToken(resources.getString(R.string.calculator_2)) }
        binding.button3.setOnClickListener { clickToken(resources.getString(R.string.calculator_3)) }
        binding.button4.setOnClickListener { clickToken(resources.getString(R.string.calculator_4)) }
        binding.button5.setOnClickListener { clickToken(resources.getString(R.string.calculator_5)) }
        binding.button6.setOnClickListener { clickToken(resources.getString(R.string.calculator_6)) }
        binding.button7.setOnClickListener { clickToken(resources.getString(R.string.calculator_7)) }
        binding.button8.setOnClickListener { clickToken(resources.getString(R.string.calculator_8)) }
        binding.button9.setOnClickListener { clickToken(resources.getString(R.string.calculator_9)) }
        binding.buttonPlus.setOnClickListener { clickToken(resources.getString(R.string.calculator_plus)) }
        binding.buttonMinus.setOnClickListener { clickToken(resources.getString(R.string.calculator_minus)) }
        binding.buttonMultiply.setOnClickListener { clickToken(resources.getString(R.string.calculator_multiply)) }
        binding.buttonDivide.setOnClickListener { clickToken(resources.getString(R.string.calculator_divide)) }
        binding.buttonDelete.setOnClickListener { clickDelete() }
        binding.buttonEquals.setOnClickListener {
            runCatching { Calculator().evaluate(expression.token) }
                .onSuccess { result ->
                    binding.textView.text = result.toString()
                    expression.clearAndAddResult(result)
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

    private fun clickToken(token: String) {
        expression.add(token)
        updateTextView()
    }

    private fun clickDelete() {
        expression.delete()
        updateTextView()
    }

    private fun updateTextView() {
        binding.textView.text = expression.getTokenToString()
    }
}
