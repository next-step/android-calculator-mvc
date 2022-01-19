package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNumberButtonListener()
        setupArithmeticButtonListener()
        setupFunctionButtonListener()
    }

    private fun setupNumberButtonListener() = with(binding) {
        button0.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_0)}" }
        button1.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_1)}" }
        button2.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_2)}" }
        button3.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_3)}" }
        button4.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_4)}" }
        button5.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_5)}" }
        button6.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_6)}" }
        button7.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_7)}" }
        button8.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_8)}" }
        button9.setOnClickListener { textView.text = "${textView.text}${getString(R.string.calculator_9)}" }
    }

    private fun setupArithmeticButtonListener() = with(binding) {
        buttonPlus.setOnClickListener {
            if (hasOperand()) {
                textView.text = "${textView.text} ${getString(R.string.calculator_plus)} "
            }

        }
        buttonMinus.setOnClickListener {
            if (hasOperand()) {
                textView.text = "${textView.text} ${getString(R.string.calculator_minus)} "
            }

        }
        buttonMultiply.setOnClickListener {
            if (hasOperand()) {
                textView.text = "${textView.text} ${getString(R.string.calculator_multiply)} "
            }
        }
        buttonDivide.setOnClickListener {
            if (hasOperand()) {
                textView.text = "${textView.text} ${getString(R.string.calculator_divide)} "
            }
        }
    }

    private fun hasOperand(): Boolean = with(binding) {
        val input = textView.text
        return input.isNotBlank() && input.last() != ' '
    }

    private fun setupFunctionButtonListener() = with(binding) {
        buttonDelete.setOnClickListener {
            val text = textView.text
            if (text.isBlank()) return@setOnClickListener
            val numberSize = 1
            val operatorSize = 3
            textView.text = text.dropLast(
                text.last().toString()
                    .toIntOrNull()?.let { numberSize } ?: operatorSize
            )
        }
        buttonEquals.setOnClickListener {
            if (textView.text.isBlank()) return@setOnClickListener
            runCatching {
                textView.text = Calculator.calculate(textView.text.toString()).toString()
            }.getOrElse {
                Toast.makeText(this@MainActivity, getString(R.string.calculator_incomplete_expression), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
