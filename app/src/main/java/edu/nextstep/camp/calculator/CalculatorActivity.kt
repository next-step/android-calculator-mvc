package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityCalculatorBinding
import edu.nextstep.camp.domain.stringcalculator.CalculatorMemory
import edu.nextstep.camp.domain.stringcalculator.Operand
import edu.nextstep.camp.domain.stringcalculator.Operator
import edu.nextstep.camp.domain.stringcalculator.StringCalculator

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private val calculatorMemory = CalculatorMemory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listOf(
            binding.buttonZero,
            binding.buttonOne,
            binding.buttonTwo,
            binding.buttonThree,
            binding.buttonFour,
            binding.buttonFive,
            binding.buttonSix,
            binding.buttonSeven,
            binding.buttonEight,
            binding.buttonNine,
        ).forEach { button ->
            button.setOnClickListener { onOperandClick(button.text.toString()) }
        }

        listOf(
            binding.buttonPlus,
            binding.buttonMinus,
            binding.buttonMultiply,
            binding.buttonDivide,
        ).forEach { button ->
            button.setOnClickListener { onOperatorClick(button.text.toString()) }
        }

        binding.buttonDelete.setOnClickListener { onDeleteClick() }
        binding.buttonEquals.setOnClickListener { onResultClick() }
    }

    private fun onOperandClick(input: String) {
        val operand = Operand(input)
        val expression = calculatorMemory.putOperand(operand)
        binding.textResult.text = expression
    }

    private fun onOperatorClick(input: String) {
        val operator = Operator.find(input)
        val expression = calculatorMemory.putOperator(operator)
        binding.textResult.text = expression
    }

    private fun onDeleteClick() {
        val expression = calculatorMemory.removeLast()
        binding.textResult.text = expression
    }

    private fun onResultClick() {
        val expression = calculatorMemory.getExpression()
        try {
            val result = StringCalculator.calculate(expression)
            binding.textResult.text = result.toString()
        } catch (e: Exception) {
            Toast.makeText(this, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT).show()
        }
    }
}
