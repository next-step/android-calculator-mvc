package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.Calculator
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator = Calculator()

    private val buttonNumberList: MutableList<Button> by lazy {
        mutableListOf(
            binding.button0, binding.button1,
            binding.button2, binding.button3,
            binding.button4, binding.button5,
            binding.button6, binding.button7,
            binding.button8, binding.button9,
        )
    }

    private val buttonOperatorList: MutableList<Button> by lazy {
        mutableListOf(
            binding.buttonDivide, binding.buttonMultiply,
            binding.buttonMinus, binding.buttonPlus
        )
    }

    private var currentExpression: String? = ""
        set(value) {
            binding.textView.text = value
            field = value
        }
        get() {
            return binding.textView.text.toString()
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
    }

    private fun addNumberButtonListener(button: Button) {
        button.setOnClickListener { display(button) }
    }

    private fun addOperatorButtonListener(button: Button) {
        button.setOnClickListener {
            displayOperator(button)
        }
    }

    private fun checkAndCompute() {
        if (currentExpression.isNullOrEmpty()) {
            displayToast(getString(R.string.toastIncompleteExpression))
            return
        }
        if (!currentExpression!!.last().isDigit()) {
            displayToast(getString(R.string.toastIncompleteExpression))
            return
        }

        currentExpression = calculator.evaluate(currentExpression).toString()
    }

    private fun display(button: Button) {
        currentExpression += button.text.toString()
    }

    private fun modify(operator: String) {
        currentExpression = currentExpression!!
            .subSequence(0 until currentExpression!!.lastIndex)
            .toString()
            .plus(operator)
    }

    private fun displayOperator(button: Button) {
        if (currentExpression.isNullOrEmpty()) return
        if (!currentExpression!!.last().isDigit()) {
            modify(button.text.toString())
            return
        }
        display(button)
    }

    private fun displayToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}