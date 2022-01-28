package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.Calculator
import com.example.calculator.Expression
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator = Calculator()
    private var expression = Expression.EMPTY

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
        binding.buttonEquals.setOnClickListener { displayResult() }
        binding.buttonDelete.setOnClickListener { displayDelete() }
    }

    private fun addNumberButtonListener(button: Button) {
        button.setOnClickListener {
            expression += button.text.toString()
            display()
        }
    }

    private fun addOperatorButtonListener(button: Button) {
        button.setOnClickListener {
            expression = expression.addOperator(button.text.toString())
            display()
        }
    }

    private fun display() {
        binding.textView.text = expression.rawExpression
    }

    private fun displayToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun displayResult() {
        if (!expression.isValidate()) {
            displayToast(getString(R.string.toastIncompleteExpression))
            return
        }
        expression = Expression.EMPTY + calculator.evaluate(expression.rawExpression).toString()
        display()
    }

    private fun displayDelete() {
        expression = expression.deleteExpression()
        display()
    }
}