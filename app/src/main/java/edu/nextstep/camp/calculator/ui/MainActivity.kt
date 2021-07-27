package edu.nextstep.camp.calculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.Number
import edu.nextstep.camp.calculator.domain.Operator
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var expression = Expression()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonListener()
    }

    private fun setButtonListener() = with(binding) {
        button0.setOnClickListener { numberButtonClicked("0") }
        button1.setOnClickListener { numberButtonClicked("1") }
        button2.setOnClickListener { numberButtonClicked("2") }
        button3.setOnClickListener { numberButtonClicked("3") }
        button4.setOnClickListener { numberButtonClicked("4") }
        button5.setOnClickListener { numberButtonClicked("5") }
        button6.setOnClickListener { numberButtonClicked("6") }
        button7.setOnClickListener { numberButtonClicked("7") }
        button8.setOnClickListener { numberButtonClicked("8") }
        button9.setOnClickListener { numberButtonClicked("9") }

        buttonPlus.setOnClickListener { operatorButtonClicked("+") }
        buttonMinus.setOnClickListener { operatorButtonClicked("-") }
        buttonMultiply.setOnClickListener { operatorButtonClicked("×") }
        buttonDivide.setOnClickListener { operatorButtonClicked("÷") }

        buttonEquals.setOnClickListener { calculateButtonClicked() }
        buttonDelete.setOnClickListener { deleteButtonClicked() }
    }

    private fun numberButtonClicked(number: String) {
        binding.textviewOutput.text = expression.writeNumber(Number(number))
    }

    private fun operatorButtonClicked(operator: String) {
        binding.textviewOutput.text = expression.writeOperator(Operator.of(operator))
    }

    private fun deleteButtonClicked() {
        binding.textviewOutput.text = expression.deleteExpression()
    }

    private fun calculateButtonClicked() {
        val result = expression.calculate()
        binding.textviewOutput.text = result
    }
}
