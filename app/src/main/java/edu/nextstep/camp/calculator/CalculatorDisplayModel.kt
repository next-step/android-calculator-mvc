package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator
import java.util.Stack

class CalculatorDisplayModel {

    private val _state: Stack<String> = Stack()
    val state get() = _state.joinToString(separator = " ")

    private val calculator = Calculator()

    fun put(number: Int) {
        require(number in 0..9) { "Invalid number $number, must be between 0 and 9." }
        if (_state.isEmpty()) {
            _state.add(number.toString())
        } else if (_state.last().isOperand()) {
            val prevOperand = _state.pop()
            _state.push("$prevOperand$number")
        } else {
            _state.add(number.toString())
        }
    }

    fun put(op: String) {
        if (_state.isEmpty()) return
        if (_state.last().isOperator()) {
            _state.pop()
        }
        _state.add(op)
    }

    fun delete() {
        if (_state.isEmpty()) return
        val prev = _state.pop()
        if (prev.isOperand() && prev.length >= 2) {
            _state.push(prev.substring(0, prev.length - 1))
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

    private fun String.isOperator(): Boolean {
        return !isOperand()
    }
}
