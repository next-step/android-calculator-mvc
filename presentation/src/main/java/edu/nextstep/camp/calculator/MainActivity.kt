package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import com.github.dodobest.domain.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val inputFarm = InputFarm()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener {
            inputFarm.handleInputNum("0")
            refreshTextView()
        }

        binding.button1.setOnClickListener {
            inputFarm.handleInputNum("1")
            refreshTextView()
        }
        binding.button2.setOnClickListener {
            inputFarm.handleInputNum("2")
            refreshTextView()
        }
        binding.button3.setOnClickListener {
            inputFarm.handleInputNum("3")
            refreshTextView()
        }
        binding.button4.setOnClickListener {
            inputFarm.handleInputNum("4")
            refreshTextView()
        }
        binding.button5.setOnClickListener {
            inputFarm.handleInputNum("5")
            refreshTextView()
        }
        binding.button6.setOnClickListener {
            inputFarm.handleInputNum("6")
            refreshTextView()
        }
        binding.button7.setOnClickListener {
            inputFarm.handleInputNum("7")
            refreshTextView()
        }
        binding.button8.setOnClickListener {
            inputFarm.handleInputNum("8")
            refreshTextView()
        }
        binding.button9.setOnClickListener {
            inputFarm.handleInputNum("9")
            refreshTextView()
        }

        binding.buttonPlus.setOnClickListener {
            inputFarm.handleInputArithmetic("+")
            refreshTextView()
        }

        binding.buttonMinus.setOnClickListener {
            inputFarm.handleInputArithmetic("-")
            refreshTextView()
        }

        binding.buttonMultiply.setOnClickListener {
            inputFarm.handleInputArithmetic("*")
            refreshTextView()
        }

        binding.buttonDivide.setOnClickListener {
            inputFarm.handleInputArithmetic("/")
            refreshTextView()
        }

        binding.buttonDelete.setOnClickListener {
            inputFarm.handleInputDelete()
            refreshTextView()
        }

        binding.buttonEquals.setOnClickListener {
            if (inputFarm.checkExpressionCanCalculated()) {
                inputFarm.handleEquals()
                refreshTextView()
            } else {
                Toast.makeText(this, "완성되지 않은 수식입니다", Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun refreshTextView() {
        binding.textView.text = inputFarm.getString()
    }
}
