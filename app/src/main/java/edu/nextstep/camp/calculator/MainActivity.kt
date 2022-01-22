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
        onClickNumberButton(getDisplayContents(), button as Button)
    }

    private val operatorButtonClickListener = View.OnClickListener { button ->
        onClickOperatorButton(getDisplayContents(), button as Button)
    }

    private val deleteButtonClickListener = View.OnClickListener {
        onClickDeleteButton(getDisplayContents())
    }

    private val equalsButtonClickListener = View.OnClickListener {
        onClickEqualsButton(getDisplayContents())
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

    private fun onClickNumberButton(contents: String, button: Button) {
        val result = CalculatorContentsModifier.appendNumber(contents, button.text.toString())
        setDisplayContents(result)
    }

    private fun onClickOperatorButton(contents: String, button: Button) {
        val result = CalculatorContentsModifier.appendOperator(contents, button.text.toString())
        setDisplayContents(result)
    }

    private fun onClickDeleteButton(contents: String) {
        val result = CalculatorContentsModifier.removeLatest(contents)
        setDisplayContents(result)
    }

    private fun onClickEqualsButton(contents: String) {
        val result = try {
            CalculatorContentsModifier.calculateContents(contents)
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, R.string.uncompleted_operation, Toast.LENGTH_SHORT).show()
            return
        }

        setDisplayContents(result)
    }

    private fun getDisplayContents(): String {
        return binding.textView.text.toString()
    }

    private fun setDisplayContents(contents: String) {
        binding.textView.text = contents
    }
}
