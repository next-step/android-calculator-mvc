package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListener()
    }

    private fun setupListener() = with(binding){
        button0.setOnClickListener {
            textView.text = "0"
        }

        button1.setOnClickListener {
            textView.text = "1"
        }

        button2.setOnClickListener {
            textView.text = "2"
        }

        button3.setOnClickListener {
            textView.text = "3"
        }

        button4.setOnClickListener {
            textView.text = "4"
        }

        button5.setOnClickListener {
            textView.text = "5"
        }

        button6.setOnClickListener {
            textView.text = "6"
        }

        button7.setOnClickListener {
            textView.text = "7"
        }

        button8.setOnClickListener {
            textView.text = "8"
        }

        button9.setOnClickListener {
            textView.text = "9"
        }
    }
}
