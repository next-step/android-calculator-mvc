package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initOperandButtonClickListener()
        initOperatorButtonClickListener()
    }

    private fun initOperandButtonClickListener() = with(binding) {
        button0.setOnClickListener {
            textFormula.append("0")
        }
        button1.setOnClickListener {
            textFormula.append("1")
        }
        button2.setOnClickListener {
            textFormula.append("2")
        }
        button3.setOnClickListener {
            textFormula.append("3")
        }
        button4.setOnClickListener {
            textFormula.append("4")
        }
        button5.setOnClickListener {
            textFormula.append("5")
        }
        button6.setOnClickListener {
            textFormula.append("6")
        }
        button7.setOnClickListener {
            textFormula.append("7")
        }
        button8.setOnClickListener {
            textFormula.append("8")
        }
        button9.setOnClickListener {
            textFormula.append("9")
        }
    }

    private fun initOperatorButtonClickListener() = with(binding) {
        buttonDivide.setOnClickListener {
            textFormula.append(operatorDisplay(textFormula.text.toString(), getString(R.string.calculator_divide)))
        }
        buttonMultiply.setOnClickListener {
            textFormula.append(operatorDisplay(textFormula.text.toString(), getString(R.string.calculator_multiply)))
        }
        buttonMinus.setOnClickListener {
            textFormula.append(operatorDisplay(textFormula.text.toString(), getString(R.string.calculator_minus)))
        }
        buttonPlus.setOnClickListener {
            textFormula.append(operatorDisplay(textFormula.text.toString(), getString(R.string.calculator_plus)))
        }
    }

    private fun operatorDisplay(currentView : String, appendText: String): String = when{
        currentView.isEmpty()-> ""
        else -> appendText
    }
}
