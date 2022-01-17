package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.Calculator.calculate
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
        button0.setOnClickListener { textView.text = "${textView.text}0" }
        button1.setOnClickListener { textView.text = "${textView.text}1" }
        button2.setOnClickListener { textView.text = "${textView.text}2" }
        button3.setOnClickListener { textView.text = "${textView.text}3" }
        button4.setOnClickListener { textView.text = "${textView.text}4" }
        button5.setOnClickListener { textView.text = "${textView.text}5" }
        button6.setOnClickListener { textView.text = "${textView.text}6" }
        button7.setOnClickListener { textView.text = "${textView.text}7" }
        button8.setOnClickListener { textView.text = "${textView.text}8" }
        button9.setOnClickListener { textView.text = "${textView.text}9" }
    }

    private fun setupArithmeticButtonListener() = with(binding) {
        buttonPlus.setOnClickListener {
            if (hasOperand()) {
                textView.text = "${textView.text} + "
            }

        }
        buttonMinus.setOnClickListener {
            if (hasOperand()) {
                textView.text = "${textView.text} - "
            }

        }
        buttonMultiply.setOnClickListener {
            if (hasOperand()) {
                textView.text = "${textView.text} * "
            }
        }
        buttonDivide.setOnClickListener {
            if (hasOperand()) {
                textView.text = "${textView.text} / "
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
            textView.text = text.dropLast(
                text.last().toString()
                    .toIntOrNull()?.let { 1 } ?: 3
            )
        }
        buttonEquals.setOnClickListener {
            if (textView.text.isBlank()) return@setOnClickListener
            runCatching {
                textView.text = calculate(textView.text.toString()).toString()
            }.getOrElse {
                Toast.makeText(this@MainActivity, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
