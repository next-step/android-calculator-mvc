package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.exception.ExpressionNotCompleteException
import edu.nextstep.camp.calculator.domain.ExpressionTokenProcessor
import edu.nextstep.camp.calculator.domain.model.OtherExpressionToken
import edu.nextstep.camp.calculator.domain.model.ExpressionToken
import org.jetbrains.annotations.TestOnly
import kotlin.runCatching

class MainActivity : AppCompatActivity(), UserInputActionReceiver {
    private lateinit var binding: ActivityMainBinding
    private val expressionTokenProcessor by lazy { ExpressionTokenProcessor() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            lifecycleOwner = this@MainActivity
            inputHandler = this@MainActivity
        }
    }

    override fun onReceiveUserInputAction(v: View) {
        kotlin.runCatching { v as Button }
            .onFailure { handleExceptions(IllegalArgumentException("Input action view type must be Button")) }
            .onSuccess { processInputButton(it) }
    }

    private fun processInputButton(btn: Button) {
        if (btn.text.isNullOrEmpty()) {
            if (btn.id == R.id.buttonDelete) processInputAction(OtherExpressionToken.DEL)
            else handleExceptions(IllegalArgumentException("Unknown Input"))
        }
        else {
            processInputAction(ExpressionToken.getFromValue(btn.text.toString()))
        }
    }

    private fun processInputAction(inputAction: ExpressionToken) {
        runCatching {
            binding.textView.text = expressionTokenProcessor.processUserInputAction(inputAction)
        }
            .onFailure {
                handleExceptions(it)
            }
    }

    private fun handleExceptions(throwable: Throwable) {
        when (throwable) {
            is ExpressionNotCompleteException -> {
                Toast.makeText(this, R.string.expression_not_complete_message, Toast.LENGTH_SHORT).show()
            }
            is ArithmeticException -> {
                Toast.makeText(this, R.string.div_by_zero_message, Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, R.string.unknown_error_message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    @TestOnly
    fun setDisplayedText(displayedText: String) {
        binding.textView.text = expressionTokenProcessor.setCurrentDisplayedText(displayedText)
    }
}
