package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.domain.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
        ).forEach { button ->
            button.setOnClickListener {
                onClickButtonSetText("${binding.textView.text}${button.text}")
            }
        }

        listOf(
            binding.buttonDivide,
            binding.buttonMultiply,
            binding.buttonMinus,
            binding.buttonPlus
        ).forEach { button ->
            button.setOnClickListener {
                onClickButtonSetText("${binding.textView.text} ${button.text} ")
            }
        }

        binding.buttonDelete.setOnClickListener {
            binding.textView.text = binding.textView.text.dropLast(1)
        }

        binding.buttonEquals.setOnClickListener {
            try {
                val calculator = Calculator
                val result = calculator.calculate(binding.textView.text.toString())
                binding.textView.text = result
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, "${e.message.toString()}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onClickButtonSetText(input: String) {
        binding.textView.text = input
    }
}
