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

        initListener()
    }

    private fun initListener() {
        with(binding) {
            listOf(
                button0, button1, button2, button3, button4,
                button5, button6, button7, button8, button9,
            ).forEach { button ->
                button.setOnClickListener { setOutput(button.text.toString()) }
            }
        }
    }

    private fun setOutput(output: String) {
        binding.outputTextView.text = output
    }
}
