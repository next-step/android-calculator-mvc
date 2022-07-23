package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.calculator.domain.Calculator
import edu.nextstep.calculator.domain.ExpressionManager
import edu.nextstep.calculator.domain.Operator
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val expressionManager = ExpressionManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()
    }

    private fun bindViews() {
        binding.button0.setOnClickListener {
            onClickButton("0")
        }
        binding.button1.setOnClickListener {
            onClickButton("1")
        }
        binding.button2.setOnClickListener {
            onClickButton("2")
        }
        binding.button3.setOnClickListener {
            onClickButton("3")
        }
        binding.button4.setOnClickListener {
            onClickButton("4")
        }
        binding.button5.setOnClickListener {
            onClickButton("5")
        }
        binding.button6.setOnClickListener {
            onClickButton("6")
        }
        binding.button7.setOnClickListener {
            onClickButton("7")
        }
        binding.button8.setOnClickListener {
            onClickButton("8")
        }
        binding.button9.setOnClickListener {
            onClickButton("9")
        }

        binding.buttonDelete.setOnClickListener {
            onClickEraseButton()
        }
        binding.buttonPlus.setOnClickListener {
            onClickButton(Operator.PLUS.value)
        }
        binding.buttonMinus.setOnClickListener {
            onClickButton(Operator.MINUS.value)
        }
        binding.buttonMultiply.setOnClickListener {
            onClickButton(Operator.MULTIPLY.value)
        }
        binding.buttonDivide.setOnClickListener {
            onClickButton(Operator.DIVIDE.value)
        }

        binding.buttonEquals.setOnClickListener {
            onClickEqualsButton()
        }
    }

    private fun onClickButton(content: String) {
        expressionManager.input(content)
        binding.textView.text = expressionManager.getExpression()
    }

    private fun onClickEraseButton() {
        expressionManager.erase()
        binding.textView.text = expressionManager.getExpression()
    }

    private fun onClickEqualsButton() {
        if (expressionManager.isEnableCalculateExpression().not()) {
            Toast.makeText(this@MainActivity, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT).show()
            return
        }

        val result = Calculator.calculate(expressionManager.getExpression()).toString()
        binding.textView.text = result

        expressionManager.resetExpression(result)
    }
}
