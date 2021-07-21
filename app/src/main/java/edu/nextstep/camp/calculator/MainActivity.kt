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

        binding.button0.setOnClickListener {
            binding.textView.text = "0"
        }

        binding.button1.setOnClickListener {
            binding.textView.text = "1"
        }

        binding.button2.setOnClickListener {
            binding.textView.text = "2"
        }

        binding.button3.setOnClickListener {
            binding.textView.text = "3"
        }

        binding.button4.setOnClickListener {
            binding.textView.text = "4"
        }

        binding.button5.setOnClickListener {
            binding.textView.text = "5"
        }
    }
}
