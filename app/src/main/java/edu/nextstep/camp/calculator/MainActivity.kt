package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calculator: Calculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculator = Calculator()
        setViewClickListener()
    }

    private fun setViewClickListener() {
        binding.button0.setOnClickListener { addString("0") }
        binding.button1.setOnClickListener { addString("1") }
        binding.button2.setOnClickListener { addString("2") }
        binding.button3.setOnClickListener { addString("3") }
        binding.button4.setOnClickListener { addString("4") }
        binding.button5.setOnClickListener { addString("5") }
        binding.button6.setOnClickListener { addString("6") }
        binding.button7.setOnClickListener { addString("7") }
        binding.button8.setOnClickListener { addString("8") }
        binding.button9.setOnClickListener { addString("9") }
        binding.buttonDivide.setOnClickListener { addString(" / ") }
        binding.buttonMinus.setOnClickListener { addString(" - ") }
        binding.buttonMultiply.setOnClickListener { addString(" * ") }
        binding.buttonPlus.setOnClickListener { addString(" + ") }
        binding.buttonEquals.setOnClickListener { calculateString() }
        binding.buttonDelete.setOnClickListener { deleteString() }
    }

    private fun addString(text: String) {
        val expression = binding.tvResult.text
        binding.tvResult.text = "$expression$text"
    }

    private fun calculateString() {
        val expression = binding.tvResult.text.toString()
        binding.tvResult.text = calculator.evaluate(expression).toString()
    }

    private fun deleteString() {
        binding.tvResult.text = binding.tvResult.text.dropLast(1)
    }
}
