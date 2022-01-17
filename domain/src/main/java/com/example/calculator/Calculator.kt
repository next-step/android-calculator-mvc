package com.example.calculator

import java.lang.IllegalArgumentException

class Calculator {
    private var result = 0
    private var currentOperator: Operator = Operator.PLUS
    private val expressionRegex = "^([0-9][-X/+*])+[0-9]".toRegex()

    fun evaluate(inputString: String): Int {
        result = 0
        val expression = inputString.trim()
        checkExpression(expression)
        expression.forEach { calculate(it) }
        return result
    }

    private fun calculate(char: Char) {
        if (char.isDigit()) {
            when (currentOperator) {
                Operator.PLUS -> result += Character.getNumericValue(char)
                Operator.MINUS -> result -= Character.getNumericValue(char)
                Operator.DIVIDE -> result /= Character.getNumericValue(char)
                Operator.MULTIPLY -> result *= Character.getNumericValue(char)
            }
        }
        currentOperator = Operator.get(char)

    }

    private fun checkExpression(string: String?) {
        if (string == null || !expressionRegex.matches(string)) throw IllegalArgumentException()
    }

}