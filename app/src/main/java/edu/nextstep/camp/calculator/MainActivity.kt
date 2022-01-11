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

        setOnclickListener()
    }

    private fun setOnclickListener() {
        binding.button0.setOnClickListener { binding.textViewDisplay.text = "0" }
        binding.button1.setOnClickListener { binding.textViewDisplay.text = "1" }
        binding.button2.setOnClickListener { binding.textViewDisplay.text = "2" }
        binding.button3.setOnClickListener { binding.textViewDisplay.text = "3" }
        binding.button4.setOnClickListener { binding.textViewDisplay.text = "4" }
        binding.button5.setOnClickListener { binding.textViewDisplay.text = "5" }
        binding.button6.setOnClickListener { binding.textViewDisplay.text = "6" }
        binding.button7.setOnClickListener { binding.textViewDisplay.text = "7" }
        binding.button8.setOnClickListener { binding.textViewDisplay.text = "8" }
        binding.button9.setOnClickListener { binding.textViewDisplay.text = "9" }
    }
}
