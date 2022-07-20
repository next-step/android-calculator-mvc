package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.domain.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var expression = Expression()
    private val calculator = Calculator(ExpressionValidityCheckerImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener {
            expression += NumberOperandToken("0")

            binding.textView.text = expression.toString()
        }
        binding.button1.setOnClickListener {
            expression += NumberOperandToken("1")

            binding.textView.text = expression.toString()
        }
        binding.button2.setOnClickListener {
            expression += NumberOperandToken("2")

            binding.textView.text = expression.toString()
        }
        binding.button3.setOnClickListener {
            expression += NumberOperandToken("3")

            binding.textView.text = expression.toString()
        }
        binding.button4.setOnClickListener {
            expression += NumberOperandToken("4")

            binding.textView.text = expression.toString()
        }
        binding.button5.setOnClickListener {
            expression += NumberOperandToken("5")

            binding.textView.text = expression.toString()
        }
        binding.button6.setOnClickListener {
            expression += NumberOperandToken("6")

            binding.textView.text = expression.toString()
        }
        binding.button7.setOnClickListener {
            expression += NumberOperandToken("7")

            binding.textView.text = expression.toString()
        }
        binding.button8.setOnClickListener {
            expression += NumberOperandToken("8")

            binding.textView.text = expression.toString()
        }
        binding.button9.setOnClickListener {
            expression += NumberOperandToken("9")

            binding.textView.text = expression.toString()
        }
        binding.buttonDelete.setOnClickListener {
            expression = expression.removeLastCharacter()

            binding.textView.text = expression.toString()
        }
        binding.buttonPlus.setOnClickListener {
            expression += OperatorToken.Addition

            binding.textView.text = expression.toString()
        }
        binding.buttonMinus.setOnClickListener {
            expression += OperatorToken.Subtraction

            binding.textView.text = expression.toString()
        }
        binding.buttonMultiply.setOnClickListener {
            expression += OperatorToken.Multiplication

            binding.textView.text = expression.toString()
        }
        binding.buttonDivide.setOnClickListener {
            expression += OperatorToken.Division

            binding.textView.text = expression.toString()
        }
        binding.buttonEquals.setOnClickListener {
            if (expression.isCompleteExpression().not()) {
                return@setOnClickListener
            }

            val evaluatedValue = calculator.evaluate(expression.toString())
            binding.textView.text = "$evaluatedValue"
            expression = Expression() + NumberOperandToken("${evaluatedValue.toInt()}")
        }
    }
}
