package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import net.woogear.domain.Calculator
import net.woogear.domain.Formula

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.run {
            setButtonsClickListener(
                button0, button1, button2, button3, button4, button5, button6, button7, button8,
                button9, buttonMinus, buttonPlus,
            )

            buttonDivide.setOnClickListener { input("/") }
            buttonMultiply.setOnClickListener { input("*") }
            buttonDelete.setOnClickListener { delete() }
            buttonEquals.setOnClickListener { calculateIfFormulaCompleted() }
        }
    }

    private fun setButtonsClickListener(vararg buttons: Button) {
        buttons.forEach { it ->
            it.setOnClickListener { input((it as Button).text.toString()) }
        }
    }

    private fun input(newText: String) {
        val formula = Formula(binding.textView.text.toString())
        binding.textView.text = formula.input(newText).formula
    }

    private fun delete() {
        val formula = Formula(binding.textView.text.toString())
        binding.textView.text = formula.delete().formula
    }

    private fun calculateIfFormulaCompleted() {
        val formula = Formula(binding.textView.text.toString())
        val isFormulaCompleted = formula.isFormulaCompleted()

        if (isFormulaCompleted) {
            binding.textView.text = calculator.evaluate(formula.formula).toString()
            return
        }

        Toast.makeText(this, getString(R.string.formula_is_not_completed), Toast.LENGTH_SHORT)
            .show()
    }
}
