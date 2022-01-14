package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.domain.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { binding.textView.text = "${binding.textView.text}0" }
        binding.button1.setOnClickListener { binding.textView.text = "${binding.textView.text}1" }
        binding.button2.setOnClickListener { binding.textView.text = "${binding.textView.text}2" }
        binding.button3.setOnClickListener { binding.textView.text = "${binding.textView.text}3" }
        binding.button4.setOnClickListener { binding.textView.text = "${binding.textView.text}4" }
        binding.button5.setOnClickListener { binding.textView.text = "${binding.textView.text}5" }
        binding.button6.setOnClickListener { binding.textView.text = "${binding.textView.text}6" }
        binding.button7.setOnClickListener { binding.textView.text = "${binding.textView.text}7" }
        binding.button8.setOnClickListener { binding.textView.text = "${binding.textView.text}8" }
        binding.button9.setOnClickListener { binding.textView.text = "${binding.textView.text}9" }
        binding.buttonDelete.setOnClickListener {
            binding.textView.text = binding.textView.text.dropLast(1)
        }
        binding.buttonDivide.setOnClickListener {
            binding.textView.text = "${binding.textView.text} / "
        }
        binding.buttonMultiply.setOnClickListener {
            binding.textView.text = "${binding.textView.text} * "
        }
        binding.buttonMinus.setOnClickListener {
            binding.textView.text = "${binding.textView.text} - "
        }
        binding.buttonPlus.setOnClickListener {
            binding.textView.text = "${binding.textView.text} + "
        }
        binding.buttonEquals.setOnClickListener {
            try {
                val result = calculator.calculate(binding.textView.text.toString())
                binding.textView.text = result
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, "${e.message.toString()}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
