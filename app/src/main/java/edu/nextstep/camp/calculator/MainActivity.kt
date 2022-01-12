package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.CalculatorDisplay

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val calculatorDisplay = CalculatorDisplay()

    private val buttonClickListener = View.OnClickListener {
        if (it is Button) {
            calculatorDisplay.setDisplayStringFromNumber(
                it.text
                    .toString()
                    .toInt()
            )

            refreshCalculatorDisplay()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener(buttonClickListener)
        binding.button1.setOnClickListener(buttonClickListener)
        binding.button2.setOnClickListener(buttonClickListener)
        binding.button3.setOnClickListener(buttonClickListener)
        binding.button4.setOnClickListener(buttonClickListener)
        binding.button5.setOnClickListener(buttonClickListener)
        binding.button6.setOnClickListener(buttonClickListener)
        binding.button7.setOnClickListener(buttonClickListener)
        binding.button8.setOnClickListener(buttonClickListener)
        binding.button9.setOnClickListener(buttonClickListener)
    }

    private fun refreshCalculatorDisplay() {
        binding.textView.text = calculatorDisplay.displayString
    }
}
