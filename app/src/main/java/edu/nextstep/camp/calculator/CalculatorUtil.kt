package edu.nextstep.camp.calculator

import com.example.domain.Calculator
import com.example.domain.Operation

class CalculatorUtil {

    private val calculator = Calculator()

    private val inputBuilder = StringBuilder()

    val result get() = inputBuilder.toString()

    fun addText(input: String) {
        if (Operation.check(input)) {
            if (inputBuilder.isNotEmpty()) {
                inputBuilder.append(input)
            }
            return
        }

        inputBuilder.append(input)
    }

    fun delete() {
        if (inputBuilder.isNotEmpty()) {
            inputBuilder.deleteAt(inputBuilder.lastIndex)
        }
    }

    fun divide() {
        if (inputBuilder.isNotEmpty()) {
            inputBuilder.append(Operation.DIVISION.operation)
        }
    }

    fun multiply() {
        if (inputBuilder.isNotEmpty()) {
            inputBuilder.append(Operation.MULTIPLICATION.operation)
        }
    }

    fun minus() {
        if (inputBuilder.isNotEmpty()) {
            inputBuilder.append(Operation.SUBTRACTION.operation)
        }
    }

    fun plus() {
        if (inputBuilder.isNotEmpty()) {
            inputBuilder.append(Operation.PLUS.operation)
        }
    }

    @Throws(IllegalArgumentException::class)
    fun equals() {
        val equalsBuilder = StringBuilder()
        inputBuilder.forEach { input ->
            val inputForCalculate = getInputForCalculate(input)
            equalsBuilder.append(inputForCalculate)
        }

        val result = calculator.evaluate(equalsBuilder.toString()).toInt()
        inputBuilder.clear()
        inputBuilder.append(result)
    }

    private fun getInputForCalculate(input: Char) = if (Operation.check(input.toString())) {
        "$SEPARATOR$input$SEPARATOR"
    } else {
        input.toString()
    }

    companion object {

        private const val SEPARATOR = " "
    }
}