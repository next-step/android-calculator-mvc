package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAddEventListener()
    }

    private fun initAddEventListener() {
        binding.button0.setOnClickListener { onClickNumberButton(binding.button0.text.toString()) }
        binding.button1.setOnClickListener { onClickNumberButton(binding.button1.text.toString()) }
        binding.button2.setOnClickListener { onClickNumberButton(binding.button2.text.toString()) }
        binding.button3.setOnClickListener { onClickNumberButton(binding.button3.text.toString()) }
        binding.button4.setOnClickListener { onClickNumberButton(binding.button4.text.toString()) }
        binding.button5.setOnClickListener { onClickNumberButton(binding.button5.text.toString()) }
        binding.button6.setOnClickListener { onClickNumberButton(binding.button6.text.toString()) }
        binding.button7.setOnClickListener { onClickNumberButton(binding.button7.text.toString()) }
        binding.button8.setOnClickListener { onClickNumberButton(binding.button8.text.toString()) }
        binding.button9.setOnClickListener { onClickNumberButton(binding.button9.text.toString()) }

        binding.buttonDivide.setOnClickListener { onClickOperatorButton(binding.buttonDivide.text.toString()) }
        binding.buttonMultiply.setOnClickListener { onClickOperatorButton(binding.buttonMultiply.text.toString()) }
        binding.buttonMinus.setOnClickListener { onClickOperatorButton(binding.buttonMinus.text.toString()) }
        binding.buttonPlus.setOnClickListener { onClickOperatorButton(binding.buttonPlus.text.toString()) }

        binding.buttonEquals.setOnClickListener { onClickEqualButton() }

        binding.buttonDelete.setOnClickListener { onClickDelete() }
    }

    private fun onClickNumberButton(string: String) {
        binding.textView.append(string)
        Expression.addNumber(string)
    }

    private fun onClickOperatorButton(string: String) {
        binding.textView.append(string)
        Expression.addOperator(string)
    }

    private fun onClickEqualButton(){
        val value = Expression.getResult()
        binding.textView.text = value.toString()
    }

    private fun onClickDelete() {
        binding.textView.text = ""
        Expression.reset()
    }
}
