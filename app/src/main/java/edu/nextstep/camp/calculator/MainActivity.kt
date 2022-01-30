package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.Calculator
import com.example.domain.Expression
import com.example.domain.Operand
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val calculate by lazy { Calculator() }

    private var expression = Expression.empty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNumberButton()
        initOperationButton()
    }

    private fun initOperationButton() {
        with(binding) {
            buttonDelete.setOnClickListener {
                expression = expression.deleteLast()
                showCalculatorResult()
            }

            buttonDivide.setOnClickListener {
                expression += Operand.DIVISION
                showCalculatorResult()
            }

            buttonMultiply.setOnClickListener {
                expression += Operand.MULTIPLICATION
                showCalculatorResult()
            }

            buttonMinus.setOnClickListener {
                expression += Operand.SUBTRACTION
                showCalculatorResult()
            }

            buttonPlus.setOnClickListener {
                expression += Operand.PLUS
                showCalculatorResult()
            }

            buttonEquals.setOnClickListener {
                try {
                    expression = expression.express(calculate)
                    showCalculatorResult()
                } catch (exception: IllegalArgumentException) {
                    showIncompleteToast()
                }
            }
        }
    }

    private fun showIncompleteToast() {
        Toast.makeText(this, getString(R.string.this_is_incomplete_formula), Toast.LENGTH_SHORT)
            .show()
    }

    private fun initNumberButton() {
        (CALCULATOR_MIN_NUMBER..CALCULATOR_MAX_NUMBER).forEach { postfixId ->
            val buttonId = resources.getIdentifier("button$postfixId", "id", packageName)
            val button = findViewById<Button?>(buttonId)
            button?.setOnClickListener {
                expression += button.text.toString()
                showCalculatorResult()
            }
        }
    }

    private fun showCalculatorResult() {
        binding.textView.text = expression.value
    }

    companion object {

        private const val CALCULATOR_MIN_NUMBER = 0

        private const val CALCULATOR_MAX_NUMBER = 9
    }
}
