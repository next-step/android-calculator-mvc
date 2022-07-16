package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.ExpressionParsingException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model = CalculatorDisplayModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { appendNumber(0) }
        binding.button1.setOnClickListener { appendNumber(1) }
        binding.button2.setOnClickListener { appendNumber(2) }
        binding.button3.setOnClickListener { appendNumber(3) }
        binding.button4.setOnClickListener { appendNumber(4) }
        binding.button5.setOnClickListener { appendNumber(5) }
        binding.button6.setOnClickListener { appendNumber(6) }
        binding.button7.setOnClickListener { appendNumber(7) }
        binding.button8.setOnClickListener { appendNumber(8) }
        binding.button9.setOnClickListener { appendNumber(9) }
        binding.buttonPlus.setOnClickListener { appendOp("+") }
        binding.buttonMinus.setOnClickListener { appendOp("-") }
        binding.buttonMultiply.setOnClickListener { appendOp("*") }
        binding.buttonDivide.setOnClickListener { appendOp("/") }
        binding.buttonEquals.setOnClickListener {
            try {
                model.calculate()
            } catch (error: ExpressionParsingException) {
                Toast.makeText(
                    this,
                    R.string.calculator_invalid_expression_message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            update()
        }
        binding.buttonDelete.setOnClickListener {
            model.delete()
            update()
        }
    }

    private fun appendNumber(number: Int) {
        model.put(number)
        update()
    }

    private fun appendOp(op: String) {
        model.put(op)
        update()
    }

    private fun update() {
        binding.textView.text = model.state
    }
}
