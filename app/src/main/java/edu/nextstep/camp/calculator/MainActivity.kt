package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.model.Calculator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initOperandButtonClickListener()
        initOperatorButtonClickListener()
        initCalculatorButtonClickListener()
    }

    private fun initOperandButtonClickListener() = with(binding) {
        listOf(
            button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9
        ).forEach{ button ->
            button.setOnClickListener {
                textFormula.append(button.text.toString())
            }
        }
    }

    private fun initOperatorButtonClickListener() = with(binding) {
        buttonDivide.setOnClickListener {
            setOperatorDisplay(getString(R.string.calculator_divide))
        }
        buttonMultiply.setOnClickListener {
            setOperatorDisplay(getString(R.string.calculator_multiply))
        }
        buttonMinus.setOnClickListener {
            setOperatorDisplay(getString(R.string.calculator_minus))
        }
        buttonPlus.setOnClickListener {
            setOperatorDisplay(getString(R.string.calculator_plus))
        }
    }

    private fun setOperatorDisplay(operator : String){
        binding.textFormula.append(
            getOperatorResult(
                binding.textFormula.text.toString(),
                " $operator "
            )
        )
    }

    private fun getOperatorResult(currentView: String, appendText: String): String = when {
        currentView.isEmpty() -> ""
        isLastTextOperand(currentView) -> appendText
        else -> appendText
    }

    private fun initCalculatorButtonClickListener() = with(binding) {
        buttonDelete.setOnClickListener {
            val result
            = getDeleteResult(textFormula.text.toString())
            textFormula.text = result
        }
        buttonEquals.setOnClickListener {
            if (!isLastTextOperand(textFormula.text.toString())) {
                showToast(R.string.msg_do_not_match_formula)
            }else{
                val result = Calculator(textFormula.text.toString()).calculate()
                textFormula.text = result.toInt().toString()
            }
        }
    }

    private fun showToast(textId: Int) {
        Toast.makeText(this, textId, Toast.LENGTH_SHORT).show()
    }

    private fun getDeleteResult(currentView: String): String = when {
        currentView.isEmpty() -> ""
        isLastTextOperand(currentView) -> currentView.dropLast(1)
        else -> currentView.dropLast(4)
    }

    private fun isLastTextOperand(currentView: String): Boolean =
        currentView.last().toString().toIntOrNull() != null
}
