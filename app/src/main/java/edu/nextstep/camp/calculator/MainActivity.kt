package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var resultText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { onClickOperand(0) }
        binding.button1.setOnClickListener { onClickOperand(1) }
        binding.button2.setOnClickListener { onClickOperand(2) }
        binding.button3.setOnClickListener { onClickOperand(3) }
        binding.button4.setOnClickListener { onClickOperand(4) }
        binding.button5.setOnClickListener { onClickOperand(5) }
        binding.button6.setOnClickListener { onClickOperand(6) }
        binding.button7.setOnClickListener { onClickOperand(7) }
        binding.button8.setOnClickListener { onClickOperand(8) }
        binding.button9.setOnClickListener { onClickOperand(9) }

        binding.buttonPlus.setOnClickListener { onClickOperator("+") }
        binding.buttonMinus.setOnClickListener { onClickOperator("-") }
        binding.buttonDivide.setOnClickListener { onClickOperator("/") }
        binding.buttonMultiply.setOnClickListener { onClickOperator("*") }

        binding.buttonDelete.setOnClickListener { onClickDelete() }
        binding.buttonEquals.setOnClickListener { onClickEquals() }
    }

    private fun onClickOperand(number: Int) {
        if (resultText.isNotEmpty() && !resultText.last().isDigit())
            resultText += " "
        resultText += number
        binding.textView.text = resultText
    }

    private fun onClickOperator(operator: String) {
        if (resultText.isEmpty()) return
        if (resultText.last().isDigit())
            resultText += " "
        else {
            resultText = resultText.dropLast(1)
        }
        resultText += operator
        binding.textView.text = resultText
    }

    private fun onClickDelete() {
        if (resultText.isEmpty()) return
        resultText = resultText.dropLast(1)
        if (resultText.last() == ' ') {
            resultText = resultText.dropLast(1)
        }
        binding.textView.text = resultText
    }

    private fun onClickEquals() {
        if (resultText.isEmpty() || !resultText.last().isDigit()) {
            Toast.makeText(this, getText(R.string.not_completed_expression), Toast.LENGTH_SHORT)
                .show()
            return
        }
        resultText = Calculator().evaluate(resultText).toString()
        binding.textView.text = resultText
    }
}
