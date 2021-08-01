package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.ExpressionHolder
import edu.nextstep.camp.calculator.domain.operand.NumberOperand
import edu.nextstep.camp.calculator.domain.operand.Operand
import edu.nextstep.camp.calculator.domain.operand.Operator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val expression by lazy { ExpressionHolder() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        with(binding) {
            listOf(
                button0, button1, button2, button3, button4,
                button5, button6, button7, button8, button9,
            ).forEach { button ->
                button.setOnClickListener {
                    setOperand(NumberOperand(button.text.toString().toDouble()))
                }
            }

            listOf(
                buttonMinus, buttonPlus, buttonMultiply, buttonDivide
            ).forEach { button ->
                button.setOnClickListener {
                    setOperand(Operator.getOperator(button.text.toString()))
                }
            }
            buttonDelete.setOnClickListener {
                setOutput(expression.deleteLast())
            }

            buttonEquals.setOnClickListener {
                val result = kotlin.runCatching { expression.getResult() }
                if (result.isSuccess) {
                    setOutput(result.getOrNull()?.toString() ?: "")
                } else {
                    Toast.makeText(this@MainActivity, R.string.error_expression, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun setOutput(output: String) {
        binding.outputTextView.text = output
    }

    private fun setOperand(operand: Operand) {
        setOutput(expression.addOperand(operand))
    }
}
