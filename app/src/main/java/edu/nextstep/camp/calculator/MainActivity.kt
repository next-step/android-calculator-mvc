package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.calculator.domain.Calculator
import edu.nextstep.calculator.domain.Editor
import edu.nextstep.calculator.domain.Operator
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val editor = Editor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()
    }

    private fun bindViews() {
        binding.button0.setOnClickListener {
            onClickNumberButton("0")
        }
        binding.button1.setOnClickListener {
            onClickNumberButton("1")
        }
        binding.button2.setOnClickListener {
            onClickNumberButton("2")
        }
        binding.button3.setOnClickListener {
            onClickNumberButton("3")
        }
        binding.button4.setOnClickListener {
            onClickNumberButton("4")
        }
        binding.button5.setOnClickListener {
            onClickNumberButton("5")
        }
        binding.button6.setOnClickListener {
            onClickNumberButton("6")
        }
        binding.button7.setOnClickListener {
            onClickNumberButton("7")
        }
        binding.button8.setOnClickListener {
            onClickNumberButton("8")
        }
        binding.button9.setOnClickListener {
            onClickNumberButton("9")
        }

        binding.buttonDelete.setOnClickListener {
            onClickEraseButton()
        }
        binding.buttonPlus.setOnClickListener {
            onClickOperatorButton(Operator.PLUS)
        }
        binding.buttonMinus.setOnClickListener {
            onClickOperatorButton(Operator.MINUS)
        }
        binding.buttonMultiply.setOnClickListener {
            onClickOperatorButton(Operator.MULTIPLY)
        }
        binding.buttonDivide.setOnClickListener {
            onClickOperatorButton(Operator.DIVIDE)
        }

        binding.buttonEquals.setOnClickListener {
            onClickEqualsButton()
        }
    }

    private fun onClickNumberButton(number: String) {
        editor.input(number)
        binding.textView.text = editor.getExpression()
    }

    private fun onClickOperatorButton(operator: Operator) {
        editor.input(operator)
        binding.textView.text = editor.getExpression()
    }

    private fun onClickEraseButton() {
        editor.erase()
        binding.textView.text = editor.getExpression()
    }

    private fun onClickEqualsButton() {
        if (editor.isEnableCalculateExpression()) {
            binding.textView.text = Calculator.calculate(editor.getExpression()).toString()
        } else {
            Toast.makeText(this@MainActivity, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT).show()
        }
    }
}
