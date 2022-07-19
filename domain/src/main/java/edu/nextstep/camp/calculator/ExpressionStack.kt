package edu.nextstep.camp.calculator

import java.util.*

class ExpressionStack {
    private val stack: Stack<String> = Stack()

    fun getStackPeekIntegerValue(): Int =
        if (stack.isEmpty() || stack.peek().toIntOrNull() == null) {
            throw IllegalArgumentException()
        } else {
            stack.pop().toInt()
        }

    fun pushResult(result: String) {
        stack.push(result)
    }

    fun getStackForCalculating(value: String): Stack<String>? {
        return if (stack.isEmpty()) {
            stack.push(value)
            null
        } else {
            getPushedValueStackWhenStackIsNotEmpty(stack, value)
        }
    }

    private fun getPushedValueStackWhenStackIsNotEmpty(stack: Stack<String>, str: String): Stack<String>? {
        if (isMathematicalSymbol(str)) {
            stack.push(str)
        } else if (isNumber(str)) {
            return stack
        } else {
            throw IllegalArgumentException()
        }
        return null
    }

    private fun isMathematicalSymbol(symbol: String): Boolean {
        return MathematicalSymbol.values().any() {it.type == symbol}
    }

    private fun isNumber(str: String): Boolean {
        if (str.toIntOrNull() == null) return false
        return true
    }
}