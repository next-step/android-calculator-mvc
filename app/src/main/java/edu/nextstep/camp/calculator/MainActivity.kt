package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.CalculatorInputConverter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var calculator: Calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickCalculatorButton(view: View) {
        binding.textView.append((view as Button).text)
    }

    fun onClickEqual(view: View) {
        val text = binding.textView.text.toString()
        val value = calculator.calculate(
            CalculatorInputConverter
                .getCalculatorInputToTextArr(text)
        )
        binding.textView.text = value.toString()
    }

    fun onClickDelete(view: View) {
        binding.textView.text = ""
    }
}
