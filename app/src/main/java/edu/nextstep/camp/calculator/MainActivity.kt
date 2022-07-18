package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator

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

        binding.buttonDelete.setOnClickListener { clickDelete() }
        binding.buttonEquals.setOnClickListener { clickEquals() }


    }
    private fun clickOperator(operator: String){
        if(expression.isNotEmpty() && expression.last().isDigit()){
            expression += " $operator"
        }
        binding.textView.text = expression
    }

    private fun clickOperand(value: Int){
        if(expression.isNotEmpty() && !expression.last().isDigit()){
            expression += " "
        }
        expression += value.toString()
        binding.textView.text = expression
    }

    private fun clickDelete(){
        if(expression.isEmpty()) return
        // 앞의문자가 공백이거나 소수점이면 같이 지워버리기
        val deleteSize =
            if (expression.length > 1 && (expression[expression.lastIndex - 1] == ' ' || expression[expression.lastIndex - 1] == '.')) 2 else 1
        expression = expression.substring(0, expression.length - deleteSize)

        binding.textView.text = expression
    }

    private fun clickEquals(){
        if(!expression.last().isDigit()){
            Toast.makeText(this, WRONG_EXPRESSION, Toast.LENGTH_SHORT).show()
        }else{
            val result = Calculator().evaluatesExpression(expression).toString()
            binding.textView.text = result
            expression = result
        }
    }

    companion object{
        private const val WRONG_EXPRESSION = "완성되지 않은 수식입니다"
    }

}
