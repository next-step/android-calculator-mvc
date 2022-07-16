package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator
import java.util.Stack

class CalculatorDisplayModel {

    private val _state: Stack<String> = Stack()
    val state get() = _state.joinToString(separator = " ")

    private val calculator = Calculator()

    fun put(number: Int) {
        require(number in 0..9) { "Invalid number $number, must be between 0 and 9." }
        when {
            _state.isEmpty() -> {
                _state.add(number.toString())
            }
            _state.last().isOperand() -> {
                val prevOperand = _state.pop()
                _state.push("$prevOperand$number")
            }
            else -> {
                _state.add(number.toString())
            }
        }
    }

    fun put(op: String) {
        when {
            _state.isEmpty() -> {
                return
            }
            _state.last().isOperand() -> {
                _state.add(op)
            }
            else -> {
                _state.pop()
                _state.add(op)
            }
        }
    }

    fun delete() {
        when {
            _state.isEmpty() -> {
                return
            }
            _state.last().isOperand() -> {
                val prev = _state.pop()
                if (prev.length >= 2) {
                    _state.push(prev.substring(0, prev.length - 1))
                }
            }
            else -> {
                _state.pop()
            }
        }
    }

    fun calculate() {
        val result = calculator.evaluate(state)
        _state.clear()
        _state.push(result.toString())
    }

    private fun String.isOperand(): Boolean {
        return this.toIntOrNull() != null
    }
}
