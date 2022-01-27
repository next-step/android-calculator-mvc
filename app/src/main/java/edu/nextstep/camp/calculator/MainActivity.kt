package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.Expression
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
                expression = expression.delete()
                showCalculatorResult()
            }

            buttonDivide.setOnClickListener {
                expression = expression.divide()
                showCalculatorResult()
            }

            buttonMultiply.setOnClickListener {
                expression = expression.multiply()
                showCalculatorResult()
            }

            buttonMinus.setOnClickListener {
                expression = expression.minus()
                showCalculatorResult()
            }

            buttonPlus.setOnClickListener {
                expression = expression.plus()
                showCalculatorResult()
            }

            buttonEquals.setOnClickListener {
                try {
                    expression = expression.equals()
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
                expression = expression.addText(button.text.toString())
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
