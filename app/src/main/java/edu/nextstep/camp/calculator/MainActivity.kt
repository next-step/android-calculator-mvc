package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val numberButtonClickListener = View.OnClickListener { button ->
        onClickNumberButton(getDisplayFormula(), button as Button)
    }

    private val operatorButtonClickListener = View.OnClickListener { button ->
        onClickOperatorButton(getDisplayFormula(), button as Button)
    }

    private val deleteButtonClickListener = View.OnClickListener {
        onClickDeleteButton(getDisplayFormula())
    }

    private val equalsButtonClickListener = View.OnClickListener {
        onClickEqualsButton(getDisplayFormula())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickListener()
    }

    private fun initButtonClickListener() {
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

        binding.buttonPlus.setOnClickListener(operatorButtonClickListener)
        binding.buttonMinus.setOnClickListener(operatorButtonClickListener)
        binding.buttonMultiply.setOnClickListener(operatorButtonClickListener)
        binding.buttonDivide.setOnClickListener(operatorButtonClickListener)

        binding.buttonDelete.setOnClickListener(deleteButtonClickListener)

        binding.buttonEquals.setOnClickListener(equalsButtonClickListener)
    }

    private fun onClickNumberButton(formula: String, button: Button) {
        val result = CalculatorFormulaModifier.appendOperand(formula, button.text.toString())
        setDisplayFormula(result)
    }

    private fun onClickOperatorButton(formula: String, button: Button) {
        val result = CalculatorFormulaModifier.appendOperator(formula, button.text.toString())
        setDisplayFormula(result)
    }

    private fun onClickDeleteButton(formula: String) {
        val result = CalculatorFormulaModifier.removeLatest(formula)
        setDisplayFormula(result)
    }

    private fun onClickEqualsButton(formula: String) {
        val result = try {
            CalculatorFormulaModifier.calculateFormula(formula)
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, R.string.uncompleted_operation, Toast.LENGTH_SHORT).show()
            return
        }

        setDisplayFormula(result)
    }

    private fun getDisplayFormula(): String {
        return binding.textView.text.toString()
    }

    private fun setDisplayFormula(formula: String) {
        binding.textView.text = formula
    }
}
