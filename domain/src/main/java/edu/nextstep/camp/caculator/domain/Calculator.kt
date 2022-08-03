package edu.nextstep.camp.caculator.domain

class Calculator {

    fun calculate(expression: Expression): Int {
        var result = 0
        var operator = ""
        expression.getExpressionList().map {
            when {
                Expression.AVAILABLE_INPUT_OPERATORS.contains(it) -> operator = it
                Expression.AVAILABLE_INPUT_VALUES.contains(it) -> result = operate(operator, result, it.toInt())
            }
        }

        return result
    }

    private fun operate(operator: String, x: Int, y: Int): Int{
        return when (operator) {
            "+" -> x + y
            "-" -> x - y
            "/" -> x / y
            "*" -> x * y
            else -> y
        }
    }
}