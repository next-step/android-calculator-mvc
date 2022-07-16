package edu.nextstep.camp.calculator

import java.util.Stack

class Calculator {

    fun evaluate(expression: String?): Int {
        val stack = Stack<String>()
        val expressionWithoutBlank = expression?.split(BLANK) ?: throw IllegalArgumentException()

        expressionWithoutBlank.forEach {
            if (stack.isEmpty()) {
                stack.push(it)
            } else {
                pushValueWhenStackIsNotEmpty(stack, it)
            }
        }
        return if (stack.isEmpty()) throw IllegalArgumentException() else stack.pop().toInt()
    }

    private fun pushValueWhenStackIsNotEmpty(stack: Stack<String>, str: String) {
        if (isMathematicalSymbol(str)) {
            stack.push(str)
        } else {
            val type = stack.pop()
            val value = stack.pop()
            val result = calculateValue(type, value.toInt(), str.toInt())
            stack.push(result.toString())
        }
    }

    private fun isMathematicalSymbol(symbol: String): Boolean {
        when(symbol) {
            MathematicalSymbol.PLUS.type -> return true
            MathematicalSymbol.MINUS.type -> return true
            MathematicalSymbol.MULTIPLE.type -> return true
            MathematicalSymbol.DIVIDE.type -> return true
        }
        return false
    }

    private fun calculateValue(type: String, value: Int, value2: Int) : Int {
        var result = 0
        when(type) {
            MathematicalSymbol.PLUS.type -> result = plus(value, value2)
            MathematicalSymbol.MINUS.type -> result = minus(value, value2)
            MathematicalSymbol.MULTIPLE.type -> result = multiple(value, value2)
            MathematicalSymbol.DIVIDE.type -> result = divide(value, value2)
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

    companion object {
        const val BLANK = " "
    }
}