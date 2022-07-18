package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.exception.ExpressionNotCompleteException
import edu.nextstep.camp.calculator.domain.UserInputActionProcessor
import edu.nextstep.camp.calculator.domain.model.OtherInputAction
import edu.nextstep.camp.calculator.domain.model.UserInputAction
import org.jetbrains.annotations.TestOnly
import kotlin.runCatching

class MainActivity : AppCompatActivity(), UserInputActionReceiver {
    private lateinit var binding: ActivityMainBinding
    private val userInputActionProcessor by lazy { UserInputActionProcessor() }

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
            if (btn.id == R.id.buttonDelete) processInputAction(OtherInputAction.DEL)
            else handleExceptions(IllegalArgumentException("Unknown Input"))
        }
        else {
            processInputAction(UserInputAction.getFromValue(btn.text.toString()))
        }
    }

    private fun processInputAction(inputAction: UserInputAction) {
        runCatching {
            binding.textView.text = userInputActionProcessor.processUserInputAction(inputAction)
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
        binding.textView.text = userInputActionProcessor.setCurrentDisplayedText(displayedText)
    }
}
