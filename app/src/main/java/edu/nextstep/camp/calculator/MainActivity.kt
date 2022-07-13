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

        binding.button0.setOnClickListener { binding.tvResult.text = "0" }
        binding.button1.setOnClickListener { binding.tvResult.text = "1" }
        binding.button2.setOnClickListener { binding.tvResult.text = "2" }
        binding.button3.setOnClickListener { binding.tvResult.text = "3" }
        binding.button4.setOnClickListener { binding.tvResult.text = "4" }
        binding.button5.setOnClickListener { binding.tvResult.text = "5" }
        binding.button6.setOnClickListener { binding.tvResult.text = "6" }
        binding.button7.setOnClickListener { binding.tvResult.text = "7" }
        binding.button8.setOnClickListener { binding.tvResult.text = "8" }
        binding.button9.setOnClickListener { binding.tvResult.text = "9" }
    }
}
