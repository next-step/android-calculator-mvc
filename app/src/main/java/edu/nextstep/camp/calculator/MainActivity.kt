package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.ExpressionParser

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val calculator = Calculator(ExpressionParser())
    private var expression = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { handleNumber('0') }
        binding.button1.setOnClickListener { handleNumber('1') }
        binding.button2.setOnClickListener { handleNumber('2') }
        binding.button3.setOnClickListener { handleNumber('3') }
        binding.button4.setOnClickListener { handleNumber('4') }
        binding.button5.setOnClickListener { handleNumber('5') }
        binding.button6.setOnClickListener { handleNumber('6') }
        binding.button7.setOnClickListener { handleNumber('7') }
        binding.button8.setOnClickListener { handleNumber('8') }
        binding.button9.setOnClickListener { handleNumber('9') }
        binding.buttonPlus.setOnClickListener { handleSign('+') }
        binding.buttonMinus.setOnClickListener { handleSign('-') }
        binding.buttonMultiply.setOnClickListener { handleSign('*') }
        binding.buttonDivide.setOnClickListener { handleSign('/') }
        binding.buttonDelete.setOnClickListener { handleDelete() }
        binding.buttonEquals.setOnClickListener { handleEquals() }
    }

    private fun handleNumber(number: Char) {
        when {
            expression.isEmpty() -> expression += number
            isNumber(expression.lastOrNull()) -> expression += number
            else -> expression += " $number"
        }
        binding.textView.text = expression
    }

    private fun handleSign(sign: Char) {
        if (!isNumber(expression.lastOrNull())) return

        expression += " $sign"
        binding.textView.text = expression
    }

    private fun isNumber(char: Char?): Boolean {
        return char?.let {
            NUMBER_LIST.contains(it)
        } ?: false
    }

    private fun handleDelete() {
        if (expression.lastOrNull() != null) {
            expression = expression.dropLast(1).trim()
            binding.textView.text = expression
        }
    }

    private fun handleEquals() {
        runCatching {
            calculator.evaluate(expression)
        }.onSuccess { result ->
            expression = result.toString()
            binding.textView.text = expression
        }.onFailure {
            Toast.makeText(this, getString(R.string.toast_incompleteExpression), Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private val NUMBER_LIST = "0123456789".toList()
    }
}
