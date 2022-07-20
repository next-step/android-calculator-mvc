package edu.nextstep.camp.calculator

import java.util.*

class Calculator {

    fun evaluate(stack: Stack<String>): Int {
        if (stack.size == 1) return stack.pop().toInt()
        val value = stack.pop().toInt()
        val type = stack.pop()
        val value2 = stack.pop().toInt()
        val result = calculateValue(type, value, value2)
        stack.push(result.toString())
        return evaluate(stack)
    }

    private fun calculateValue(type: String, value: Int, value2: Int) : Int {
        val result = when(type) {
            MathematicalSymbol.PLUS.type -> plus(value, value2)
            MathematicalSymbol.MINUS.type -> minus(value, value2)
            MathematicalSymbol.MULTIPLE.type -> multiple(value, value2)
            MathematicalSymbol.DIVIDE.type -> divide(value, value2)
            else -> throw IllegalArgumentException()
        }
        return result
    }

    private fun plus (value: Int, value2: Int) : Int {
        return value + value2
    }

    private fun multiple (value: Int, value2: Int) : Int {
        return value * value2
    }

    private fun divide (value: Int, value2: Int) : Int {
        return value / value2
    }

    private fun minus (value: Int, value2: Int) : Int {
        return value - value2
    }
}