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

        binding.button0.setOnClickListener { handleInput("0") }
        binding.button1.setOnClickListener { handleInput("1") }
        binding.button2.setOnClickListener { handleInput("2") }
        binding.button3.setOnClickListener { handleInput("3") }
        binding.button4.setOnClickListener { handleInput("4") }
        binding.button5.setOnClickListener { handleInput("5") }
        binding.button6.setOnClickListener { handleInput("6") }
        binding.button7.setOnClickListener { handleInput("7") }
        binding.button8.setOnClickListener { handleInput("8") }
        binding.button9.setOnClickListener { handleInput("9") }
        binding.buttonPlus.setOnClickListener { handleInput("+") }
        binding.buttonMinus.setOnClickListener { handleInput("-") }
        binding.buttonMultiply.setOnClickListener { handleInput("*") }
        binding.buttonDivide.setOnClickListener { handleInput("/") }
    }

    private fun handleInput(input: String) {
        expression += input
    }
}
