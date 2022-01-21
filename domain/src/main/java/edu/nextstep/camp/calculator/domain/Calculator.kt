package edu.nextstep.camp.calculator.domain

class Calculator {
    private var result = 0f
    private var operator = Operator.NONE

    fun evaluate(data: String): Float {
        result = 0f
        operator = Operator.NONE

        if (data.isEmpty()) {
            throw IllegalArgumentException("exception data")
        } else {
            data.forEach {
                if (it.isDigit()) {
                    calculate(it)
                } else {
                    setOperator(it)
                }
            }
        }
        return result
    }

    private fun calculate(char: Char) {
        result = when (operator) {
            Operator.PLUS -> plus(result, Character.getNumericValue(char).toFloat())
            Operator.MINUS -> minus(result, Character.getNumericValue(char).toFloat())
            Operator.MULTIPLY -> multipliedBy(result, Character.getNumericValue(char).toFloat())
            Operator.DIVIDE -> dividedBy(result, Character.getNumericValue(char).toFloat())
            Operator.NONE -> Character.getNumericValue(char).toFloat()
        }
    }

    private fun setOperator(char: Char) {
        operator = when (char.toString()) {
            "+" -> Operator.PLUS
            "-" -> Operator.MINUS
            "×" -> Operator.MULTIPLY
            "÷" -> Operator.DIVIDE
            else -> throw IllegalArgumentException("exception operator")
        }
    }

    fun plus(first: Float, second: Float): Float {
        return first + second
    }

    fun minus(first: Float, second: Float): Float {
        return first - second
    }

    fun multipliedBy(first: Float, second: Float): Float {
        return first * second
    }

    fun dividedBy(first: Float, second: Float): Float {
        return first / second
    }
}