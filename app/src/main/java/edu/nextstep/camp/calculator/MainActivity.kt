package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNumberButtonListener()
        setupOperatorButtonListener()
        setupFunctionButtonListener()
    }

    private fun setupNumberButtonListener() = with(binding){
        button0.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "0")
        }

        button1.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "1")
        }

        button2.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "2")
        }

        button3.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "3")
        }

        button4.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "4")
        }

        button5.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "5")
        }

        button6.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "6")
        }

        button7.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "7")
        }

        button8.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "8")
        }

        button9.setOnClickListener {
            textView.text = String.format("%s%s", textView.text, "9")
        }
    }

    private fun setupOperatorButtonListener() = with(binding) {
        buttonPlus.setOnClickListener {
            textView.text = OperatorDisplay.print(
                beforeText = textView.text,
                operator = Operator.PLUS
            )
        }
        buttonMinus.setOnClickListener {
            textView.text = OperatorDisplay.print(
                beforeText = textView.text,
                operator = Operator.MINUS
            )
        }
        buttonMultiply.setOnClickListener {
            textView.text = OperatorDisplay.print(
                beforeText = textView.text,
                operator = Operator.MULTIPLE
            )
        }
        buttonDivide.setOnClickListener {
            textView.text = OperatorDisplay.print(
                beforeText = textView.text,
                operator = Operator.DIVIDE
            )
        }
    }

    private fun setupFunctionButtonListener() = with(binding) {
        buttonDelete.setOnClickListener {
            if (textView.text.isNotEmpty()) textView.text = textView.text.dropLast(1)
        }
        buttonEquals.setOnClickListener {
            runCatching {
                textView.text = Calculator.calculate(Formula(textView.text.toString())).toString()
            }.getOrElse {
                Toast
                    .makeText(this@MainActivity, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
