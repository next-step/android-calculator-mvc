package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.example.calculator.Calculator
import com.example.calculator.Expression
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator = Calculator()
    private val expression = Expression.EMPTY

    private val buttonNumberList: List<Button> by lazy {
        listOf(
            binding.button0, binding.button1,
            binding.button2, binding.button3,
            binding.button4, binding.button5,
            binding.button6, binding.button7,
            binding.button8, binding.button9,
        )
    }

    private val buttonOperatorList: List<Button> by lazy {
        listOf(
            binding.buttonDivide, binding.buttonMultiply,
            binding.buttonMinus, binding.buttonPlus
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        buttonNumberList.forEach { addNumberButtonListener(it) }
        buttonOperatorList.forEach { addOperatorButtonListener(it) }
        binding.buttonEquals.setOnClickListener { checkAndCompute() }
        binding.buttonDelete.setOnClickListener { deleteExpression() }
    }

    private fun addNumberButtonListener(button: Button) {
        button.setOnClickListener { addExpression(button) }
    }

    private fun addOperatorButtonListener(button: Button) {
        button.setOnClickListener {
            addOperator(button)
        }
    }

    private fun display() {
        binding.textView.text = expression.rawExpression
    }

    private fun displayToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun checkAndCompute() {
        if (expression.rawExpression.isEmpty()) {
            displayToast(getString(R.string.toastIncompleteExpression))
            return
        }
        if (!expression.rawExpression.last().isDigit()) {
            displayToast(getString(R.string.toastIncompleteExpression))
            return
        }
        if (expression.rawExpression.isDigitsOnly()) {
            displayToast(getString(R.string.toastIncompleteExpression))
            return
        }

        expression.rawExpression = calculator.evaluate(expression.rawExpression).toString()
        display()
    }

    private fun addExpression(button: Button) {
        expression.rawExpression += button.text.toString()
        display()
    }

    private fun modifyOperator(operator: String) {
        expression.rawExpression = expression.rawExpression.dropLast(1)
            .plus(operator)
        display()
    }

    private fun addOperator(button: Button) {
        if (expression.rawExpression.isEmpty()) return
        if (!expression.rawExpression.last().isDigit()) {
            modifyOperator(button.text.toString())
            return
        }
        addExpression(button)
    }

    private fun deleteExpression() {
        if (expression.rawExpression.isEmpty()) return
        expression.rawExpression =
            expression.rawExpression.subSequence(0 until expression.rawExpression.lastIndex)
                .toString()
        display()
    }
}