package edu.nextstep.camp.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.domain.*
import kotlin.math.roundToInt

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
                Toast.makeText(this, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            processOperation()
        }
    }

    private fun processOperation() {
        try {
            val evaluatedValue = calculator.evaluate(expression.toString())
            val evaluatedValueText = getEvaluatedValueText(evaluatedValue)

            binding.textView.text = evaluatedValueText
            expression = Expression() + NumberOperandToken(evaluatedValueText)
        } catch (e: Exception) {
            Log.w(MainActivity::class.simpleName, e)
            Toast.makeText(this, "유효하지 않은 수식입니다", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getEvaluatedValueText(evaluatedValue: Double) = if (evaluatedValue.roundToInt() == evaluatedValue.toInt()) {
        "${evaluatedValue.toInt()}"
    } else {
        "$evaluatedValue"
    }
}
