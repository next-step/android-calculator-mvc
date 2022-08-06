package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.caculator.domain.Calculator
import edu.nextstep.camp.caculator.domain.Expression
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator:Calculator = Calculator()
    private val expression:Expression = Expression()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { appendExpression("0") }
        binding.button1.setOnClickListener { appendExpression("1") }
        binding.button2.setOnClickListener { appendExpression( "2") }
        binding.button3.setOnClickListener { appendExpression( "3") }
        binding.button4.setOnClickListener { appendExpression("4") }
        binding.button5.setOnClickListener { appendExpression( "5") }
        binding.button6.setOnClickListener { appendExpression( "6") }
        binding.button7.setOnClickListener { appendExpression("7") }
        binding.button8.setOnClickListener { appendExpression( "8") }
        binding.button9.setOnClickListener { appendExpression("9") }
        binding.buttonPlus.setOnClickListener { appendExpression("+") }
        binding.buttonMinus.setOnClickListener { appendExpression("-") }
        binding.buttonDivide.setOnClickListener { appendExpression("/") }
        binding.buttonMultiply.setOnClickListener { appendExpression( "*") }
        binding.buttonEquals.setOnClickListener { calculate() }
        binding.buttonDelete.setOnClickListener { deleteLastExpression() }
    }
    
    private fun appendExpression(expressionString: String) {
        expression.addExpression(expressionString)
        binding.textView.text = expression.getExpressionString()
    }

    private fun deleteLastExpression() {
        expression.deleteLastExpression()
        binding.textView.text = expression.getExpressionString()
    }

    private fun calculate() {
        if (isValidExpression()) {
            binding.textView.text = calculator.calculate(expression).toString()
            expression.clear()
        }
    }

    private fun isValidExpression(): Boolean {
        return if (expression.isValidExpression()) {
            true
        } else {
            Toast.makeText(this, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
