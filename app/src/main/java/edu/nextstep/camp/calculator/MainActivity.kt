package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lcw.study.nextstep.domain.Calculator
import com.lcw.study.nextstep.domain.Expression
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var expression = Expression.EMPTY
    private var calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { addOperand(binding.button0.text.toString()) }
        binding.button1.setOnClickListener { addOperand(binding.button1.text.toString()) }
        binding.button2.setOnClickListener { addOperand(binding.button2.text.toString()) }
        binding.button3.setOnClickListener { addOperand(binding.button3.text.toString()) }
        binding.button4.setOnClickListener { addOperand(binding.button4.text.toString()) }
        binding.button5.setOnClickListener { addOperand(binding.button5.text.toString()) }
        binding.button6.setOnClickListener { addOperand(binding.button6.text.toString()) }
        binding.button7.setOnClickListener { addOperand(binding.button7.text.toString()) }
        binding.button8.setOnClickListener { addOperand(binding.button8.text.toString()) }
        binding.button9.setOnClickListener { addOperand(binding.button9.text.toString()) }
        binding.buttonPlus.setOnClickListener { addOperator(binding.buttonPlus.text.toString()) }
        binding.buttonMinus.setOnClickListener { addOperator(binding.buttonMinus.text.toString()) }
        binding.buttonMultiply.setOnClickListener { addOperator(binding.buttonMultiply.text.toString()) }
        binding.buttonDivide.setOnClickListener { addOperator(binding.buttonDivide.text.toString()) }
        binding.buttonEquals.setOnClickListener { calculate() }
        binding.buttonDelete.setOnClickListener { dropLastText() }
    }

    private fun addOperand(rawOperand: String) {
        expression += rawOperand.toInt()
        binding.textView.text = expression.rawExpression
    }

    private fun addOperator(rawOperator: String) {
        expression += rawOperator
        binding.textView.text = expression.rawExpression
    }

    private fun calculate() {
        val result = calculator.evaluate(expression.rawExpression)
        binding.textView.text = result.toString()
    }

    private fun dropLastText() {
        expression = expression.dropLast()
        println(expression)
        binding.textView.text = expression.rawExpression
    }


}
