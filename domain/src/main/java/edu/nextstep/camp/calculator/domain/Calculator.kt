package edu.nextstep.camp.calculator.domain

object Calculator {

    fun evaluate(data: String): Float {
        var result = 0f
        var operator = Operator.NONE

        if (data.isEmpty()) {
            throw IllegalArgumentException("exception data")
        } else {
            data.forEach {
                if (it.isDigit()) {
                    result = calculate(it, operator, result)
                } else {
                    operator = Operator.getOperator(it.toString())
                }
            }
        }
        return result
    }

    private fun calculate(char: Char, operator: Operator, result: Float): Float {
        return when (operator) {
            Operator.PLUS -> Operator.plus(result, Character.getNumericValue(char).toFloat())
            Operator.MINUS -> Operator.minus(result, Character.getNumericValue(char).toFloat())
            Operator.MULTIPLY -> Operator.multipliedBy(result, Character.getNumericValue(char).toFloat())
            Operator.DIVIDE -> Operator.dividedBy(result, Character.getNumericValue(char).toFloat())
            Operator.NONE -> Character.getNumericValue(char).toFloat()
        }
    }
}