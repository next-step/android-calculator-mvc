package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { appendNumber(0) }
        binding.button1.setOnClickListener { appendNumber(1) }
        binding.button2.setOnClickListener { appendNumber(2) }
        binding.button3.setOnClickListener { appendNumber(3) }
        binding.button4.setOnClickListener { appendNumber(4) }
        binding.button5.setOnClickListener { appendNumber(5) }
        binding.button6.setOnClickListener { appendNumber(6) }
        binding.button7.setOnClickListener { appendNumber(7) }
        binding.button8.setOnClickListener { appendNumber(8) }
        binding.button9.setOnClickListener { appendNumber(9) }
        binding.buttonPlus.setOnClickListener { appendOp("+") }
        binding.buttonMinus.setOnClickListener { appendOp("-") }
        binding.buttonMultiply.setOnClickListener { appendOp("*") }
        binding.buttonDivide.setOnClickListener { appendOp("/") }
        binding.buttonEquals.setOnClickListener { appendOp("=") }
        binding.buttonDelete.setOnClickListener { appendOp("<") }
    }

    private fun appendNumber(number: Int) {
        appendText(number.toString())
    }

    private fun appendOp(op: String) {
        val origin = binding.textView.text.toString()

        if (origin.isEmpty()) return
        if (origin.last().isDigit()) appendText(op)
    }

    private fun appendText(text: String) {
        val origin = binding.textView.text.toString()
        if (origin.isEmpty() || origin.toIntOrNull() != null) binding.textView.append(text)
        else binding.textView.append(" $text")
    }
}
