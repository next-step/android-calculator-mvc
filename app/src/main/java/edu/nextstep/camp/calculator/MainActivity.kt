package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.Calculator
import com.example.domain.Expression
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator by lazy { Calculator() }
    private var expression = Expression.EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initNumberButton()
        setOperatorButtonListener()
        setDeleteButtonListener()
        setEqualButtonListener()

    }


    private fun setOperatorButtonListener() = with(binding) {
        buttonPlus.setOnClickListener {
            expression += getString(R.string.calculator_plus).single()
            textView.text = expression.value
        }
        buttonMinus.setOnClickListener {
            expression += getString(R.string.calculator_minus).single()
            textView.text = expression.value
        }
        buttonMultiply.setOnClickListener {
            expression += getString(R.string.calculator_multiply).single()
            textView.text = expression.value
        }
        buttonDivide.setOnClickListener {
            expression += getString(R.string.calculator_divide).single()
            textView.text = expression.value
        }
    }

    private fun initNumberButton() {
        (0..9).forEach { postfixId ->
            val buttonId = resources.getIdentifier("button$postfixId", "id", packageName)
            val button = findViewById<Button?>(buttonId)
            button?.setOnClickListener {
                expression += button.text.single()
                showCalculatorResult()
            }
        }
    }

    private fun showCalculatorResult() {
        binding.textView.text = expression.value
    }

    private fun setDeleteButtonListener() = with(binding) {
        buttonDelete.setOnClickListener {
            expression = expression.removeLast(expression.value)
            textView.text = expression.value
        }
    }

    private fun setEqualButtonListener() = with(binding) {
        buttonEquals.setOnClickListener {
            runCatching {
                textView.text = calculator.evaluate(textView.text.toString()).toString()
            }.getOrElse {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.calculator_incomplete_expression),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

}
