package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var expression = Expression.EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
    }

    private fun initLayout() {
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

        binding.buttonDivide.setOnClickListener { addOperator(binding.buttonDivide.text.toString()) }
        binding.buttonMultiply.setOnClickListener { addOperator(binding.buttonMultiply.text.toString()) }
        binding.buttonMinus.setOnClickListener { addOperator(binding.buttonMinus.text.toString()) }
        binding.buttonPlus.setOnClickListener { addOperator(binding.buttonPlus.text.toString()) }
        binding.buttonDelete.setOnClickListener { removeLast() }

        binding.buttonEquals.setOnClickListener { getResult() }
    }

    private fun addOperand(rawOperand: String) {
        expression = expression.addOperand(rawOperand)
        setResult(expression.rawExpression)
    }

    private fun addOperator(rawOperator: String) {
        expression = expression.addOperator(rawOperator)
        setResult(expression.rawExpression)
    }

    private fun removeLast() {
        expression = expression.removeLast()
        setResult(expression.rawExpression)
    }

    private fun getResult() {
        try {
            setResult(expression.getResult().toString())
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this@MainActivity, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setResult(result: String) {
        binding.textView.text = result
    }
}
