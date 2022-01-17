package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val calculator = Calculator()

    private val numberButtonClickListener = View.OnClickListener { button ->
        appendButtonNumberToCalculator(button as Button)
        refreshCalculatorDisplay()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener(numberButtonClickListener)
        binding.button1.setOnClickListener(numberButtonClickListener)
        binding.button2.setOnClickListener(numberButtonClickListener)
        binding.button3.setOnClickListener(numberButtonClickListener)
        binding.button4.setOnClickListener(numberButtonClickListener)
        binding.button5.setOnClickListener(numberButtonClickListener)
        binding.button6.setOnClickListener(numberButtonClickListener)
        binding.button7.setOnClickListener(numberButtonClickListener)
        binding.button8.setOnClickListener(numberButtonClickListener)
        binding.button9.setOnClickListener(numberButtonClickListener)
    }

    private fun appendButtonNumberToCalculator(button: Button) {
        calculator.appendNumber(
            button.text
                .toString()
                .toInt()
        )
    }

    private fun refreshCalculatorDisplay() {
        binding.textView.text = calculator.contents
    }
}
