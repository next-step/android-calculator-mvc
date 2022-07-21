package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.calculator.domain.Editor
import edu.nextstep.calculator.domain.Operator
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val editor = Editor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()
    }

    private fun bindViews() {
        binding.button0.setOnClickListener {
            editor.input("0")
            binding.textView.text = editor.getExpression()
        }
        binding.button1.setOnClickListener {
            editor.input("1")
            binding.textView.text = editor.getExpression()
        }
        binding.button2.setOnClickListener {
            editor.input("2")
            binding.textView.text = editor.getExpression()
        }
        binding.button3.setOnClickListener {
            editor.input("3")
            binding.textView.text = editor.getExpression()
        }
        binding.button4.setOnClickListener {
            editor.input("4")
            binding.textView.text = editor.getExpression()
        }
        binding.button5.setOnClickListener {
            editor.input("5")
            binding.textView.text = editor.getExpression()
        }
        binding.button6.setOnClickListener {
            editor.input("6")
            binding.textView.text = editor.getExpression()
        }
        binding.button7.setOnClickListener {
            editor.input("7")
            binding.textView.text = editor.getExpression()
        }
        binding.button8.setOnClickListener {
            editor.input("8")
            binding.textView.text = editor.getExpression()
        }
        binding.button9.setOnClickListener {
            editor.input("9")
            binding.textView.text = editor.getExpression()
        }

        binding.buttonDelete.setOnClickListener {
            editor.erase()
            binding.textView.text = editor.getExpression()
        }
        binding.buttonPlus.setOnClickListener {
            editor.input(Operator.PLUS)
            binding.textView.text = editor.getExpression()
        }
        binding.buttonMinus.setOnClickListener {
            editor.input(Operator.MINUS)
            binding.textView.text = editor.getExpression()
        }
        binding.buttonMultiply.setOnClickListener {
            editor.input(Operator.MULTIPLY)
            binding.textView.text = editor.getExpression()
        }
        binding.buttonDivide.setOnClickListener {
            editor.input(Operator.DIVIDE)
            binding.textView.text = editor.getExpression()
        }
    }
}
