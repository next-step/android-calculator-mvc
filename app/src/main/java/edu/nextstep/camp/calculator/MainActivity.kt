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

    private val calculatorRepository = CalculatorRepository()

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
        calculatorRepository.appendNumberContent(button.text.toString())
        refreshCalculatorDisplay()
    }

    private fun onClickOperatorButton(button: Button) {
        calculatorRepository.appendOperatorContent(button.text.toString())
        refreshCalculatorDisplay()
    }

    private fun onClickDeleteButton() {
        calculatorRepository.deleteLatestContent()
        refreshCalculatorDisplay()
    }

    private fun onClickEqualsButton() {
        try {
            calculatorRepository.calculateContents()
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, R.string.uncompleted_operation, Toast.LENGTH_SHORT).show()
            return
        }

        refreshCalculatorDisplay()
    }

    private fun refreshCalculatorDisplay() {
        binding.textView.text = calculatorRepository.getDisplayContents()
    }
}
