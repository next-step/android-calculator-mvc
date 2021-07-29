package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listOf(
            binding.buttonZero,
            binding.buttonOne,
            binding.buttonTwo,
            binding.buttonThree,
            binding.buttonFour,
            binding.buttonFive,
            binding.buttonSix,
            binding.buttonSeven,
            binding.buttonEight,
            binding.buttonNine,
        ).forEach { button ->
            button.setOnClickListener { onInputButtonClick(button.text.toString()) }
        }
        binding.buttonEquals.setOnClickListener {
            Toast.makeText(this, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onInputButtonClick(input: String) {
        binding.textResult.text = input
    }
}
