package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.ExpressionBuilder
import edu.nextstep.camp.calculator.domain.Operand
import edu.nextstep.camp.calculator.domain.Operator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator by lazy { Calculator() }
    private val expressionBuilder by lazy { ExpressionBuilder() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val operandClickListener = View.OnClickListener {
            val button = it as Button
            val number = button.text.toString().toInt()
            val operand = Operand(number)
            expressionBuilder.addOperand(operand)

            binding.textView.text = uiFormatExpression()
        }

        val operatorClickListener = View.OnClickListener {
            val button = it as Button
            val operator = when (button.text.toString()) {
                "+" -> Operator.PLUS
                "-" -> Operator.MINUS
                "×" -> Operator.MULTIPLY
                "÷" -> Operator.DIVIDE
                else -> throw IllegalArgumentException("입력될 수 없는 값입니다.")
            }
            expressionBuilder.addOperator(operator)

            binding.textView.text = uiFormatExpression()
        }

        binding.button0.setOnClickListener(operandClickListener)
        binding.button1.setOnClickListener(operandClickListener)
        binding.button2.setOnClickListener(operandClickListener)
        binding.button3.setOnClickListener(operandClickListener)
        binding.button4.setOnClickListener(operandClickListener)
        binding.button5.setOnClickListener(operandClickListener)
        binding.button6.setOnClickListener(operandClickListener)
        binding.button7.setOnClickListener(operandClickListener)
        binding.button8.setOnClickListener(operandClickListener)
        binding.button9.setOnClickListener(operandClickListener)

        binding.buttonPlus.setOnClickListener(operatorClickListener)
        binding.buttonMinus.setOnClickListener(operatorClickListener)
        binding.buttonMultiply.setOnClickListener(operatorClickListener)
        binding.buttonDivide.setOnClickListener(operatorClickListener)

        binding.buttonDelete.setOnClickListener {
            expressionBuilder.removeLastToken()
            binding.textView.text = uiFormatExpression()
        }

        binding.buttonEquals.setOnClickListener {
            try {
                val result = calculator.evaluate(expressionBuilder.build())
                binding.textView.text = result.toString()
                expressionBuilder.clear()
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun uiFormatExpression(): String =
        expressionBuilder.build().replace("*", "×").replace("/", "÷")
}
