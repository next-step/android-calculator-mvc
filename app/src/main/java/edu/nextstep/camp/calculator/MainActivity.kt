package edu.nextstep.camp.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.Expression

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val expression = Expression()
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val operandButtonArray = arrayOf(
            binding.button0, binding.button1, binding.button2, binding.button3, binding.button4,
            binding.button5, binding.button6, binding.button7, binding.button8, binding.button9,
        )

        bindOnClickOperand(buttons = operandButtonArray)

        val operatorButtonArray = arrayOf(
            binding.buttonPlus, binding.buttonMinus, binding.buttonMultiply, binding.buttonDivide,
        )

        bindOnClickOperator(buttons = operatorButtonArray)

        binding.buttonDelete.setOnClickListener {
            if (expression.values.isNotEmpty()) {
                expression.dropLast()
                binding.textView.text = expression.values
                return@setOnClickListener
            }

            binding.textView.text = "0"
        }

        binding.buttonEquals.setOnClickListener {
            if (expression.values.isEmpty()) {
                Toast.makeText(applicationContext, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (expression.isLastValueOperatorCheck()) {
                Toast.makeText(applicationContext, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val value = calculator.evaluate(expression.values).toString()
            binding.textView.text = expression.complete(value)
        }
    }

    private fun bindOnClickOperand(vararg buttons: Button) {
        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                expression.addInputString(button.text.toString())
                binding.textView.text = expression.values
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindOnClickOperator(vararg buttons: Button) {
        buttons.forEach { button ->
            button.setOnClickListener {
                expression.addInputString(button.text.toString())
                binding.textView.text = expression.values
            }
        }
    }


}
