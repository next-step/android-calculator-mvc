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
        binding.button0.setNumberClickListener()
        binding.button1.setNumberClickListener()
        binding.button2.setNumberClickListener()
        binding.button3.setNumberClickListener()
        binding.button4.setNumberClickListener()
        binding.button5.setNumberClickListener()
        binding.button6.setNumberClickListener()
        binding.button7.setNumberClickListener()
        binding.button8.setNumberClickListener()
        binding.button9.setNumberClickListener()

        binding.buttonMinus.setNumberClickListener()
        binding.buttonPlus.setNumberClickListener()
        binding.buttonDivide.setOnClickListener { input("/") }
        binding.buttonMultiply.setOnClickListener { input("*") }

        binding.buttonDelete.setOnClickListener { delete() }
        binding.buttonEquals.setOnClickListener { calculateIfFormulaCompleted() }
    }

    private fun Button.setNumberClickListener() {
        setOnClickListener { it as Button
            input(it.text.toString())
        }
    }

    private fun input(newText: String) {
        val currentText = binding.textView.text.toString()
        binding.textView.text = InputManager.input(currentText, newText)
    }

    private fun delete() {
        binding.textView.text = InputManager.delete(binding.textView.text.toString())
    }

    private fun calculateIfFormulaCompleted() {
        val formula = binding.textView.text.toString()
        val isFormulaCompleted = InputManager.isFormulaComplete(formula)

        if (isFormulaCompleted) {
            binding.textView.text = InputManager.operate(formula)
            return
        }

        Toast.makeText(this, getString(R.string.formula_is_not_completed), Toast.LENGTH_SHORT).show()
    }
}
