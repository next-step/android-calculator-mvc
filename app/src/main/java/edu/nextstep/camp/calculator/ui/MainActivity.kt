package edu.nextstep.camp.calculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.Operator
import edu.nextstep.camp.calculator.domain.Operator.Companion.OPERATORS
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var expression = Stack<String>()
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

        buttonEquals.setOnClickListener { calculate() }
        buttonDelete.setOnClickListener { deleteButtonClicked()}
    }

    private fun numberButtonClicked(number: String) {
        expression.push(number)
        refreshExpressionTextView()
    }

    private fun operatorButtonClicked(operator: String) {
        if(OPERATORS.contains(expression.peek())) {
            expression.pop()
            expression.push(operator)
        } else {
            expression.push(operator)
        }
        refreshExpressionTextView()
    }

    private fun deleteButtonClicked() {
        if(expression.isNotEmpty()) {
            expression.pop()
            refreshExpressionTextView()
        }
    }

    fun calculate() {
        val result = Expression.create(expression.joinToString("")).calculate()
        binding.textviewOutput.text = result.value.toString()
        expression.clear()
    }

    fun refreshExpressionTextView() {
        binding.textviewOutput.text = expression.joinToString("")
    }
}
