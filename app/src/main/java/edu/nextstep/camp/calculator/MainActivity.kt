package edu.nextstep.camp.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import net.woogear.domain.OperationType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.button0.setOnClickListener { input((it as Button).text.toString()) }
        binding.button1.setOnClickListener { input((it as Button).text.toString()) }
        binding.button2.setOnClickListener { input((it as Button).text.toString()) }
        binding.button3.setOnClickListener { input((it as Button).text.toString()) }
        binding.button4.setOnClickListener { input((it as Button).text.toString()) }
        binding.button5.setOnClickListener { input((it as Button).text.toString()) }
        binding.button6.setOnClickListener { input((it as Button).text.toString()) }
        binding.button7.setOnClickListener { input((it as Button).text.toString()) }
        binding.button8.setOnClickListener { input((it as Button).text.toString()) }
        binding.button9.setOnClickListener { input((it as Button).text.toString()) }
        binding.buttonDivide.setOnClickListener { input((it as Button).text.toString()) }
        binding.buttonMultiply.setOnClickListener { input((it as Button).text.toString()) }
        binding.buttonMinus.setOnClickListener { input((it as Button).text.toString()) }
        binding.buttonPlus.setOnClickListener { input((it as Button).text.toString()) }

        binding.buttonDelete.setOnClickListener { }
        binding.buttonEquals.setOnClickListener { }
    }

    @SuppressLint("SetTextI18n")
    private fun input(newText: String) {
        val currentText = binding.textView.text.toString()

        if (currentText.isEmpty()) {
            if (OperationType.isOperator(newText)) {
                return
            }

            binding.textView.text = newText
            return
        }

        if (OperationType.isOperator(newText)) {
            binding.textView.text = "${binding.textView.text} $newText"
            return
        }

        val textOnScreen = binding.textView.text.toString()
        val lastText = textOnScreen.last()
        val isLastTextInt = lastText.toString().toIntOrNull() != null
        binding.textView.text =
            if (isLastTextInt) "$textOnScreen$newText" else "$textOnScreen $newText"
    }
}
