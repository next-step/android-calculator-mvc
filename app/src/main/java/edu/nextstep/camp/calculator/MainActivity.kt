package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.exception.ExpressionNotCompleteException
import edu.nextstep.camp.calculator.domain.InputController
import edu.nextstep.camp.calculator.domain.model.Input
import org.jetbrains.annotations.TestOnly
import kotlin.runCatching

class MainActivity : AppCompatActivity(), InputHandler {
    private lateinit var binding: ActivityMainBinding
    private val inputController by lazy { InputController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            lifecycleOwner = this@MainActivity
            inputHandler = this@MainActivity
        }
    }

    override fun handleInput(input: Input) {
        runCatching {
            binding.textView.text = inputController.onReceiveInput(input)
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
        binding.textView.text = inputController.setCurrentDisplayedText(displayedText)
    }
}
