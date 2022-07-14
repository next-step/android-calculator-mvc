package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.InputController
import edu.nextstep.camp.calculator.domain.model.Operand
import edu.nextstep.camp.calculator.domain.model.Operator
import edu.nextstep.camp.calculator.domain.model.Symbol

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

    override fun handleNumberInput(number: Int) {
        binding.textView.text = inputController.onReceiveInput(Operand(number))
    }

    override fun handleOperatorInput(operator: Operator) {
        binding.textView.text = inputController.onReceiveInput(operator)
    }

    override fun handleSymbolInput(symbol: Symbol) {
        binding.textView.text = inputController.onReceiveInput(symbol)
    }
}
