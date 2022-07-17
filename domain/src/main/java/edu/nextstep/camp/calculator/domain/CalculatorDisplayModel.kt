package edu.nextstep.camp.calculator.domain

import java.util.Stack

class CalculatorDisplayModel {

    private val tokens = Stack<Token>()
    val displayText
        get() = tokens.joinToString(
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
        if (tokens.isEmpty()) {
            tokens.add(number.toOperand())
            return
        }

        when (val last = tokens.last()) {
            is Operand -> {
                tokens.pop()
                tokens.push(last.merge(number))
            }
            is Operator -> {
                tokens.push(number.toOperand())
            }
        }
    }

    fun put(op: String) {
        if (tokens.isEmpty()) {
            return
        }

        when (tokens.last()) {
            is Operand -> {
                tokens.push(op.toOperator())
            }
            is Operator -> {
                tokens.pop()
                tokens.push(op.toOperator())
            }
        }
    }

    fun delete() {
        if (tokens.isEmpty()) return
        when (val last = tokens.last()) {
            is Operand -> {
                if (last.number < 10) {
                    tokens.pop()
                } else {
                    tokens.pop()
                    tokens.push(last.dropLast())
                }
            }
            is Operator -> tokens.pop()
        }
    }

    fun calculate() {
        val calculator = Calculator()
        val result = calculator.evaluate(tokens)
        tokens.clear()
        tokens.push(result.toOperand())
    }

    private fun Int.toOperand() = Operand(this)
    private fun Operand.merge(number: Int) = Operand("${this.number}$number".toInt())
    private fun String.toOperator() = Operator.of(this)
    private fun Operand.dropLast() = Operand(number / 10)
}
