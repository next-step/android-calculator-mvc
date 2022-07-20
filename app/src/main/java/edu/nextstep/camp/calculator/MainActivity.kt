package edu.nextstep.camp.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.ExpressionBuilder

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
            val operand = button.text.toString()
            expressionBuilder.addOperand(operand)

            binding.textView.text = expressionBuilder.getUiExpressionText()
        }

        val operatorClickListener = View.OnClickListener {
            val button = it as Button
            val operator = button.text.toString()
            expressionBuilder.addOperator(operator)

            binding.textView.text = expressionBuilder.getUiExpressionText()
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

        binding.buttonDelete.setOnClickListener{
            expressionBuilder.removeLastToken()
            binding.textView.text = expressionBuilder.getUiExpressionText()
        }

        binding.buttonEquals.setOnClickListener {
            try {
                val result = calculator.evaluate(expressionBuilder.getValidExpressionText())
                binding.textView.text = result.toString()
                expressionBuilder.clear()
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
