package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var displayContents = mutableListOf<String>()

    private var latestInputType = CalculatorLatestInputType.NONE

    private val numberButtonClickListener = View.OnClickListener { button ->
        onClickNumberButton(button as Button)
    }

    private val operatorButtonClickListener = View.OnClickListener { button ->
        onClickOperatorButton(button as Button)
    }

    private val deleteButtonClickListener = View.OnClickListener {
        onClickDeleteButton()
    }

    private val equalsButtonClickListener = View.OnClickListener {
        onClickEqualsButton()
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

    private fun onClickNumberButton(button: Button) {
        latestInputType = CalculatorLatestInputType.NUMBER

        displayContents.add(button.text.toString())
        refreshCalculatorDisplay()
    }

    private fun onClickOperatorButton(button: Button) {
        if (latestInputType == CalculatorLatestInputType.NONE) {
            return
        }

        if (latestInputType == CalculatorLatestInputType.OPERATOR) {
            displayContents.removeLast()
        }

        latestInputType = CalculatorLatestInputType.OPERATOR

        displayContents.add(" ${button.text} ")
        refreshCalculatorDisplay()
    }

    private fun onClickDeleteButton() {
        if (displayContents.isEmpty()) {
            latestInputType = CalculatorLatestInputType.NONE
            return
        }

        displayContents.removeLast()
        refreshCalculatorDisplay()
    }

    private fun onClickEqualsButton() {
        if (latestInputType == CalculatorLatestInputType.NONE || latestInputType == CalculatorLatestInputType.OPERATOR) {
            Toast.makeText(this, R.string.uncompleted_operation, Toast.LENGTH_SHORT).show()
            return
        }

        val result = Calculator.calculateContents(buildStringFromDisplayContentsList())
        displayContents.clear()

        if (result.rem(1).equals(0.0)) {
            displayContents.add(result.toInt().toString())
        } else {
            displayContents.add(result.toString())
        }

        refreshCalculatorDisplay()
    }

    private fun buildStringFromDisplayContentsList(): String {
        val displayContentsBuilder = StringBuilder()

        displayContents.forEach {
            displayContentsBuilder.append(it)
        }

        return displayContentsBuilder.toString()
    }

    private fun refreshCalculatorDisplay() {
        binding.textView.text = buildStringFromDisplayContentsList()
    }
}
