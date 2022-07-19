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

        val tokenClickListener = View.OnClickListener {
            val button = it as Button
            val token = button.text.toString()
            if (token.toIntOrNull() == null) {
                expressionBuilder.addOperator(token)
            } else {
                expressionBuilder.addOperand(token)
            }

            binding.textView.text = expressionBuilder.getUiExpressionText()
            Log.w("Main", "*${binding.textView.text}*")
        }

        binding.button0.setOnClickListener(tokenClickListener)
        binding.button1.setOnClickListener(tokenClickListener)
        binding.button2.setOnClickListener(tokenClickListener)
        binding.button3.setOnClickListener(tokenClickListener)
        binding.button4.setOnClickListener(tokenClickListener)
        binding.button5.setOnClickListener(tokenClickListener)
        binding.button6.setOnClickListener(tokenClickListener)
        binding.button7.setOnClickListener(tokenClickListener)
        binding.button8.setOnClickListener(tokenClickListener)
        binding.button9.setOnClickListener(tokenClickListener)
        binding.buttonPlus.setOnClickListener(tokenClickListener)
        binding.buttonMinus.setOnClickListener(tokenClickListener)
        binding.buttonMultiply.setOnClickListener(tokenClickListener)
        binding.buttonDivide.setOnClickListener(tokenClickListener)


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
