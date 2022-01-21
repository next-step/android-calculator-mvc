package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
    }

    private fun initLayout() {
        // 지우기
        binding.buttonDelete.setOnClickListener {
            binding.textView.text = ""
        }
        // 숫자
        binding.button0.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button0.text.toString()
        }
        binding.button1.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button1.text.toString()
        }
        binding.button2.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button2.text.toString()
        }
        binding.button3.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button3.text.toString()
        }
        binding.button4.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button4.text.toString()
        }
        binding.button5.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button5.text.toString()
        }
        binding.button6.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button6.text.toString()
        }
        binding.button7.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button7.text.toString()
        }
        binding.button8.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button8.text.toString()
        }
        binding.button9.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.button9.text.toString()
        }
        // 연산
        binding.buttonDivide.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.buttonDivide.text.toString()
        }
        binding.buttonMultiply.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.buttonMultiply.text.toString()
        }
        binding.buttonMinus.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.buttonMinus.text.toString()
        }
        binding.buttonPlus.setOnClickListener {
            binding.textView.text = binding.textView.text.toString() + binding.buttonPlus.text.toString()
        }
        // 결과
        binding.buttonEquals.setOnClickListener {
            binding.textView.text = calculator.evaluate(binding.textView.text.toString()).toString()
        }
    }
}
