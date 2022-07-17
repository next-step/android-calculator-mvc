package edu.nextstep.camp.calculator.domain

import java.util.Stack

class CalculatorDisplayModel {

    private val _tokens = Stack<Token>()
    val displayText
        get() = _tokens.joinToString(
            separator = " ",
            transform = {
                when (it) {
                    is Operand -> it.number.toString()
                    is Operator -> it.symbol
                }
            }
        )

    fun put(number: Int) {
        require(number in 0..9) { "Invalid number $number, must be between 0 and 9." }
        if (_tokens.isEmpty()) {
            _tokens.add(number.toOperand())
            return
        }

        when (val last = _tokens.last()) {
            is Operand -> {
                _tokens.pop()
                _tokens.push(last.merge(number))
            }
            is Operator -> {
                _tokens.push(number.toOperand())
            }
        }
    }

    fun put(op: String) {
        if (_tokens.isEmpty()) {
            return
        }

        when (_tokens.last()) {
            is Operand -> {
                _tokens.push(op.toOperator())
            }
            is Operator -> {
                _tokens.pop()
                _tokens.push(op.toOperator())
            }
        }
    }

    fun delete() {
        if (_tokens.isEmpty()) return
        when (val last = _tokens.last()) {
            is Operand -> {
                if (last.number < 10) _tokens.pop()
                else {
                    _tokens.pop()
                    _tokens.push(last.dropLast())
                }
            }
            is Operator -> _tokens.pop()
        }
    }

    fun calculate() {
        val calculator = Calculator()
        val result = calculator.evaluate(_tokens)
        _tokens.clear()
        _tokens.push(result.toOperand())
    }

    private fun Int.toOperand() = Operand(this)
    private fun Operand.merge(number: Int) = Operand("${this.number}$number".toInt())
    private fun String.toOperator() = Operator.of(this)
    private fun Operand.dropLast() = Operand(number / 10)
}
