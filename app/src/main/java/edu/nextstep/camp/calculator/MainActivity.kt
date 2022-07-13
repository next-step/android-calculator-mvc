package edu.nextstep.camp.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val displayedText: String
        get() = binding.textView.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewBinding()
        initNumberButtons()
    }

    private fun initNumberButtons() {
        (0..9).forEach { number ->
            val viewId = resources.getIdentifier("button$number", "id", packageName)
            val button: View = findViewById(viewId)
            button.setOnClickListener {
                val text = displayedText + number
                binding.textView.text = text
            }
        }
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
