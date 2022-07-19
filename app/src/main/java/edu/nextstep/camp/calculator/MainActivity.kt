package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Operation

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainLogic: MainActivityViewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initializeLayout()
        observeViewState()
    }

    private fun initializeLayout() {
        setContentView(binding.root)
        binding.button0.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 0)) }
        binding.button1.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 1)) }
        binding.button2.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 2)) }
        binding.button3.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 3)) }
        binding.button4.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 4)) }
        binding.button5.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 5)) }
        binding.button6.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 6)) }
        binding.button7.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 7)) }
        binding.button8.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 8)) }
        binding.button9.setOnClickListener { mainLogic.onEvent(MainEvent.AddNumber("${binding.textView.text}", 9)) }
        binding.buttonDelete.setOnClickListener { mainLogic.onEvent(MainEvent.DeleteLast("${binding.textView.text}")) }
        binding.buttonDivide.setOnClickListener { mainLogic.onEvent(MainEvent.AddOperator("${binding.textView.text}", Operation.Div.operator)) }
        binding.buttonPlus.setOnClickListener { mainLogic.onEvent(MainEvent.AddOperator("${binding.textView.text}", Operation.Plus.operator)) }
        binding.buttonMinus.setOnClickListener { mainLogic.onEvent(MainEvent.AddOperator("${binding.textView.text}", Operation.Minus.operator)) }
        binding.buttonMultiply.setOnClickListener { mainLogic.onEvent(MainEvent.AddOperator("${binding.textView.text}", Operation.Mult.operator)) }
        binding.buttonEquals.setOnClickListener { mainLogic.onEvent(MainEvent.Evalute("${binding.textView.text}")) }
    }

    private fun observeViewState(){
        mainLogic.viewState.observe(this, this::onViewState)
    }

    //ui update
    private fun onViewState(state: MainState) = when(state) {
        is MainState.DisplayText -> binding.textView.text = state.displayText
        is MainState.ShowToast -> Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
    }
}
