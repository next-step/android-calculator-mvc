package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.ExpressionParser
import edu.nextstep.camp.calculator.domain.raw.RawExpression
import edu.nextstep.camp.calculator.domain.raw.RawNumber
import edu.nextstep.camp.calculator.domain.raw.RawSign

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val calculator = Calculator(ExpressionParser())
    private val builder = RawExpression.Builder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { enterNumber(RawNumber.ZERO) }
        binding.button1.setOnClickListener { enterNumber(RawNumber.ONE) }
        binding.button2.setOnClickListener { enterNumber(RawNumber.TWO) }
        binding.button3.setOnClickListener { enterNumber(RawNumber.THREE) }
        binding.button4.setOnClickListener { enterNumber(RawNumber.FOUR) }
        binding.button5.setOnClickListener { enterNumber(RawNumber.FIVE) }
        binding.button6.setOnClickListener { enterNumber(RawNumber.SIX) }
        binding.button7.setOnClickListener { enterNumber(RawNumber.SEVEN) }
        binding.button8.setOnClickListener { enterNumber(RawNumber.EIGHT) }
        binding.button9.setOnClickListener { enterNumber(RawNumber.NINE) }
        binding.buttonPlus.setOnClickListener { enterSign(RawSign.PLUS) }
        binding.buttonMinus.setOnClickListener { enterSign(RawSign.MINUS) }
        binding.buttonMultiply.setOnClickListener { enterSign(RawSign.TIMES) }
        binding.buttonDivide.setOnClickListener { enterSign(RawSign.DIVISION) }
        binding.buttonDelete.setOnClickListener { remove() }
        binding.buttonEquals.setOnClickListener { calculate() }
    }

    private fun enterNumber(number: RawNumber) {
        builder.enterNumber(number)
        binding.textView.text = builder.build()
    }

    private fun enterSign(sign: RawSign) {
        builder.enterSign(sign)
        binding.textView.text = builder.build()
    }

    private fun remove() {
        builder.remove()
        binding.textView.text = builder.build()
    }

    private fun calculate() {
        runCatching {
            calculator.evaluate(builder.build())
        }.onSuccess { result ->
            binding.textView.text = builder
                .initialize(result)
                .build()
        }.onFailure {
            Toast.makeText(this, getString(R.string.toast_incompleteExpression), Toast.LENGTH_SHORT).show()
        }
    }
}
