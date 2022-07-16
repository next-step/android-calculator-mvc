package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.soolee.domain.Calculator
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calculator: Calculator

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textView = binding.textView
    }

    fun onClickNumber(view: View) {
        textView.append((view as Button).text)
    }

    fun onClickOperation(view: View) {
        textView.append((view as Button).text)
    }

    fun onClickEqual(view: View) {
        val text = textView.text.toString()
        calculator = Calculator()
        val value = calculator.calculate(text)
        textView.text = value.toString()
    }

    fun onClickDelete(view: View) {
        textView.text = ""
    }
}
