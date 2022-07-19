package edu.nextstep.camp.calculator.domain

import java.util.*

/**
 * Created by link.js on 2022. 07. 19..
 */
class Expression(private val delimiter: Char) {
    private val expressionStack = Stack<String>()
    val expression: String
        get() = expressionStack.joinToString(delimiter.toString())

    fun addOperand(number: String) {
        if (expressionStack.isNotEmpty() && expressionStack.last().toIntOrNull() != null) {
            expressionStack.push(expressionStack.pop() + number)
        } else {
            expressionStack.push(number)
        }
    }

    fun addOperator(operator: String) {
        if (expressionStack.isEmpty()) return
        if (expressionStack.last().toIntOrNull() == null) {
            expressionStack.pop()
        }
        expressionStack.push(operator)
    }

    fun delete() {
        if (expressionStack.isEmpty()) return
        val value = expressionStack.pop()
        if (value.toIntOrNull() == null) return
        if (value.toInt() >= SMALLEST_OF_TWO_DIGITS) {
            expressionStack.push(value.dropLast(1))
        }
    }

    fun evaluate(onShowErrorToast: (() -> Unit)? = null) {
        if (expressionStack.isEmpty() || expressionStack.last().toIntOrNull() == null) {
            onShowErrorToast?.invoke()
            return
        }
        val expression = expressionStack.joinToString(delimiter.toString())
        val result = Calculator(delimiter).evaluate(expression)

        expressionStack.clear()
        expressionStack.push(result.toString())
    }

    companion object {
        private const val SMALLEST_OF_TWO_DIGITS = 10
    }

}