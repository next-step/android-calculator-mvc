package edu.nextstep.camp.calculator

import java.util.*

class Expression {
    private val stack: Stack<String> = Stack()

    fun setStackForCalculating(input: String?) {
        val expressionWithoutBlank = input?.split(DELIMITER) ?: throw IllegalArgumentException()

        for (index in expressionWithoutBlank.size -1 downTo 0) {
            val str = expressionWithoutBlank[index]
            pushedValuesStack(str)
        }
    }

    fun isReadyForCalculating(): Boolean = stack.size != 1

    fun getCurrentValue(): Int = stack.peek().toInt()

    fun getOperand(): Int = stack.pop().toInt()

    fun getOperator(): String = stack.pop()

    fun pushResult(value: Int) {
        stack.push(value.toString())
    }

    private fun pushedValuesStack(str: String) {
        if (isNumber(str).not() && isMathematicalSymbol(str).not()) {
            throw IllegalArgumentException()
        }
        stack.push(str)
    }

    private fun isMathematicalSymbol(symbol: String): Boolean {
        return MathematicalSymbol.values().any() {it.type == symbol}
    }

    private fun isNumber(str: String): Boolean {
        if (str.toIntOrNull() == null) return false
        return true
    }

    companion object {
        const val DELIMITER = " "
    }
}