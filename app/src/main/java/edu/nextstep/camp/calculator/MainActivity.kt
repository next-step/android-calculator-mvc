package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var number = Number(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            button0.setOnClickListener { pushNumber(Number(0)) }
            button1.setOnClickListener { pushNumber(Number(1)) }
            button2.setOnClickListener { pushNumber(Number(2)) }
            button3.setOnClickListener { pushNumber(Number(3)) }
            button4.setOnClickListener { pushNumber(Number(4)) }
            button5.setOnClickListener { pushNumber(Number(5)) }
            button6.setOnClickListener { pushNumber(Number(6)) }
            button7.setOnClickListener { pushNumber(Number(7)) }
            button8.setOnClickListener { pushNumber(Number(8)) }
            button9.setOnClickListener { pushNumber(Number(9)) }
        }
        setContentView(binding.root)
    }

    private fun pushNumber(number: Number) {
        this.number = number
        binding.tvResult.text = number.int.toString()
    }
}
