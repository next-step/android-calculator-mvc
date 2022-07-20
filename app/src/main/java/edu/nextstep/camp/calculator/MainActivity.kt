package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOperandButtons()
    }

    private fun setOperandButtons() {
        fun Button.setOperandButtonClickListener(number: String) = this.setOnClickListener {
            binding.textView.text = number
        }
        binding.button0.setOperandButtonClickListener("0")
        binding.button1.setOperandButtonClickListener("1")
        binding.button2.setOperandButtonClickListener("2")
        binding.button3.setOperandButtonClickListener("3")
        binding.button4.setOperandButtonClickListener("4")
        binding.button5.setOperandButtonClickListener("5")
        binding.button6.setOperandButtonClickListener("6")
        binding.button7.setOperandButtonClickListener("7")
        binding.button8.setOperandButtonClickListener("8")
        binding.button9.setOperandButtonClickListener("9")
    }

}
