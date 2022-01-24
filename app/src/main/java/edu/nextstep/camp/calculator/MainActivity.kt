package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.Operation
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.plus = Operation.Add
        binding.minus = Operation.Subtract
        binding.multiply = Operation.Multiply
        binding.divide = Operation.Divide
        setContentView(binding.root)

        viewModel.showToast.subscribe({
            if (it) Toast.makeText(this, "완성되지 않은 수식입니다", Toast.LENGTH_LONG).show()
        }, {})
    }
}
