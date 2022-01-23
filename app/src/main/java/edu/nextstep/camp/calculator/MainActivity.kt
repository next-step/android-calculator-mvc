package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import net.woogear.domain.InputManager

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

        binding.buttonMinus.setOnClickListener { input((it as Button).text.toString()) }
        binding.buttonPlus.setOnClickListener { input((it as Button).text.toString()) }
        binding.buttonDivide.setOnClickListener { input("/") }
        binding.buttonMultiply.setOnClickListener { input("*") }

        binding.buttonDelete.setOnClickListener { delete() }
        binding.buttonEquals.setOnClickListener { setResult() }
    }

    private fun input(newText: String) {
        val currentText = binding.textView.text.toString()
        binding.textView.text = InputManager.input(currentText, newText)
    }

    private fun delete() {
        binding.textView.text = InputManager.delete(binding.textView.text.toString())
    }

    private fun setResult() {
        val formula = binding.textView.text.toString()
        val isFormulaComplete = InputManager.isFormulaComplete(formula)

        if (isFormulaComplete) {
            binding.textView.text = InputManager.operate(formula)
            return
        }

        Toast.makeText(this, getString(R.string.formula_is_not_completed), Toast.LENGTH_SHORT).show()
    }
}
