package edu.nextstep.camp.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.Operation
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = MainViewModel()
        binding.plus = Operation.Add
        binding.minus = Operation.Subtract
        binding.multiply = Operation.Multiply
        binding.divide = Operation.Divide
        setContentView(binding.root)
    }
}
