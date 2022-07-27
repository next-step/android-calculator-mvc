package edu.nextstep.camp.caculator.domain

class Calculator {

    private val expressionList = mutableListOf<String>()

    fun calculate(expression: String): Int {
        if (expression.isEmpty()) throw IllegalArgumentException("Expression is empty")
        var result = 0

        expression.split(' ').map {
            if (it.isNotEmpty() && (AVAILABLE_INPUT_VALUES.contains(it) || AVAILABLE_INPUT_OPERATORS.contains(it))) {
                expressionList.add(it)
            } else {
                throw IllegalArgumentException("There is a wrong expression")
            }
        }

        var operator = ""
        expressionList.map {
            when {
                AVAILABLE_INPUT_OPERATORS.contains(it) -> operator = it
                AVAILABLE_INPUT_VALUES.contains(it) -> {
                    when (operator) {
                        "+" -> result += it.toInt()
                        "-" -> result -= it.toInt()
                        "/" -> result /= it.toInt()
                        "*" -> result *= it.toInt()
                        else -> result = it.toInt()
                    }
                }
                else -> throw IllegalArgumentException("There is ")
            }
        }

        return result
    }

    internal fun plus(x: Int, y: Int) = x + y
    internal fun minus(x: Int, y: Int) = x - y
    internal fun divide(x: Int, y: Int) = x / y
    internal fun multiply(x: Int, y: Int) = x * y

    companion object {
        private const val AVAILABLE_INPUT_VALUES = "0123456789"
        private const val AVAILABLE_INPUT_OPERATORS = "+-/*"
    }
}