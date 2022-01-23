package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manjee.domain.OperationStorage
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val operationStorage by lazy { OperationStorage() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { inputOperand(getString(R.string.calculator_0)) }
        binding.button1.setOnClickListener { inputOperand(getString(R.string.calculator_1)) }
        binding.button2.setOnClickListener { inputOperand(getString(R.string.calculator_2)) }
        binding.button3.setOnClickListener { inputOperand(getString(R.string.calculator_3)) }
        binding.button4.setOnClickListener { inputOperand(getString(R.string.calculator_4)) }
        binding.button5.setOnClickListener { inputOperand(getString(R.string.calculator_5)) }
        binding.button6.setOnClickListener { inputOperand(getString(R.string.calculator_6)) }
        binding.button7.setOnClickListener { inputOperand(getString(R.string.calculator_7)) }
        binding.button8.setOnClickListener { inputOperand(getString(R.string.calculator_8)) }
        binding.button9.setOnClickListener { inputOperand(getString(R.string.calculator_9)) }
    }

    private fun inputOperand(num: String) {
        binding.textView.text = operationStorage.addOperand(binding.textView.text.toString(), num)
    }
}
