package edu.nextstep.camp.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.button0.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button1.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button2.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button3.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button4.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button5.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button6.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button7.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button8.setOnClickListener { input((it as TextView).text.toString()) }
        binding.button9.setOnClickListener { input((it as TextView).text.toString()) }
        binding.buttonDivide.setOnClickListener { input((it as TextView).text.toString()) }
        binding.buttonMultiply.setOnClickListener { input((it as TextView).text.toString()) }
        binding.buttonMinus.setOnClickListener { input((it as TextView).text.toString()) }
        binding.buttonPlus.setOnClickListener { input((it as TextView).text.toString()) }
    }

    @SuppressLint("SetTextI18n")
    private fun input(newText: String) {
        binding.textView.text = newText
    }
}
