package com.example.calculator

import java.lang.IllegalArgumentException

class Calculator {
    private var operand = ""
    private var result = 0
    private var currentOperator: Operator = Operator.NONE
    private val expressionRegex = "^([0-9]+[-*/+])+[0-9]+".toRegex()

    fun evaluate(inputString: String): Int {
        val expression = inputString.trim()
        checkExpression(expression)
        expression.forEach {
            calculate(it)
        }
        compute()
        return result
    }

    private fun calculate(char: Char) {
        if (char.isDigit()) {
            operand += char
        }
        if (!char.isDigit()) {
            compute()
            currentOperator = Operator.get(char)
        }
    }

    private fun compute() {
        when (currentOperator) {
            Operator.NONE -> result = operand.toInt()
            Operator.PLUS -> result += operand.toInt()
            Operator.MINUS -> result -= operand.toInt()
            Operator.DIVIDE -> result /= operand.toInt()
            Operator.MULTIPLY -> result *= operand.toInt()
        }
        operand = ""
    }

    private fun checkExpression(string: String?) {
        if (string == null || !expressionRegex.matches(string)) throw IllegalArgumentException()
    }

}