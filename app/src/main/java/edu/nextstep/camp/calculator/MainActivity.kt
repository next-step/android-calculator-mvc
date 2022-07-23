package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val expression: Expression = Expression()
    private val calculator: Calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOperandButtons()
        setOperatorButtons()
        setFunctionalButtons()
        binding.textView.text = expression.toString()
    }

    private fun setOperandButtons() {
        with(binding) {
            button0 setOperandButtonClickListener '0'
            button1 setOperandButtonClickListener '1'
            button2 setOperandButtonClickListener '2'
            button3 setOperandButtonClickListener '3'
            button4 setOperandButtonClickListener '4'
            button5 setOperandButtonClickListener '5'
            button6 setOperandButtonClickListener '6'
            button7 setOperandButtonClickListener '7'
            button8 setOperandButtonClickListener '8'
            button9 setOperandButtonClickListener '9'
        }
    }

    private fun setOperatorButtons() {
        with(binding) {
            buttonPlus setOperatorButtonClickListener '+'
            buttonMinus setOperatorButtonClickListener '-'
            buttonMultiply setOperatorButtonClickListener '×'
            buttonDivide setOperatorButtonClickListener '÷'
        }
    }

    private fun setFunctionalButtons() {
        binding.buttonDelete.setOnClickListener {
            expression.removeLast()
            binding.textView.text = expression.toString()
        }
        binding.buttonEquals.setOnClickListener {
            executeExpression()
        }
    }
    private fun executeExpression(){
        if (!expression.isCompleted()) {
            showToast(R.string.expression_not_completed)
            return
        }
        val expressionString: String = expression.toString()
        val result = calculator.calculate(expressionString)
        binding.textView.text = result.toString()
    }

    private fun showToast(@StringRes stringId: Int) {
        Toast.makeText(this@MainActivity, stringId, Toast.LENGTH_SHORT).show()
    }

    private infix fun Button.setOperatorButtonClickListener(operator: Char) =
        this.setOnClickListener {
            expression.add(operator)
            binding.textView.text = expression.toString()
        }

    private infix fun Button.setOperandButtonClickListener(number: Char) = this.setOnClickListener {
        expression.add(number)
        binding.textView.text = expression.toString()
    }

}
