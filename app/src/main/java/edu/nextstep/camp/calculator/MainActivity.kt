package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val expressionTool = Expression()
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { clickOperand(0) }
        binding.button1.setOnClickListener { clickOperand(1) }
        binding.button2.setOnClickListener { clickOperand(2) }
        binding.button3.setOnClickListener { clickOperand(3) }
        binding.button4.setOnClickListener { clickOperand(4) }
        binding.button5.setOnClickListener { clickOperand(5) }
        binding.button6.setOnClickListener { clickOperand(6) }
        binding.button7.setOnClickListener { clickOperand(7) }
        binding.button8.setOnClickListener { clickOperand(8) }
        binding.button9.setOnClickListener { clickOperand(9) }

        binding.buttonPlus.setOnClickListener { clickOperator("+") }
        binding.buttonMinus.setOnClickListener { clickOperator("-") }
        binding.buttonDivide.setOnClickListener { clickOperator("/") }
        binding.buttonMultiply.setOnClickListener { clickOperator("*") }

        binding.buttonDelete.setOnClickListener { clickDelete() }
        binding.buttonEquals.setOnClickListener { clickEquals() }


    }

    private fun clickOperator(operator: String) {
        binding.textView.text = expressionTool.addOperator(operator)
    }

    private fun clickOperand(value: Int) {
        binding.textView.text = expressionTool.addOperand(value)
    }

    private fun clickDelete() {
        binding.textView.text = expressionTool.delete()
    }

    private fun clickEquals() {
        if (!expressionTool.isCompletedExpression()) {
            Toast.makeText(this, WRONG_EXPRESSION, Toast.LENGTH_SHORT).show()
        } else {
            val result = calculator.evaluatesExpression(expressionTool)
            binding.textView.text = result.toString()
            expressionTool.initializeValue(result)
        }
    }

    companion object {
        private const val WRONG_EXPRESSION = "완성되지 않은 수식입니다"
    }

}
