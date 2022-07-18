package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var expression = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { clickOperand(0) }
        binding.button1.setOnClickListener { clickOperand(1) }
        binding.button2.setOnClickListener { clickOperand(2) }
        binding.button3.setOnClickListener { clickOperand(3) }
        binding.button4.setOnClickListener { clickOperand(4) }
        binding.button5.setOnClickListener { clickOperand(5) }
        binding.button6.setOnClickListener { clickOperand(6) }
        binding.button7.setOnClickListener { clickOperand(7) }
        binding.button8.setOnClickListener { clickOperand(8) }
        binding.button9.setOnClickListener { clickOperand(9) }

        binding.buttonPlus.setOnClickListener { clickOperator("+") }
        binding.buttonMinus.setOnClickListener {clickOperator("-")}
        binding.buttonDivide.setOnClickListener {clickOperator("/")}
        binding.buttonMultiply.setOnClickListener {clickOperator("*")}


    }
    private fun clickOperator(operator: String){
        if(expression.isNotEmpty() && expression[expression.lastIndex].isDigit()){
            expression += " $operator"
        }
        binding.textView.text = expression
    }

    private fun clickOperand(value: Int){
        if(expression.isNotEmpty() && !expression[expression.lastIndex].isDigit()){
            expression += " "
        }
        expression += value.toString()
        binding.textView.text = expression
    }

}
