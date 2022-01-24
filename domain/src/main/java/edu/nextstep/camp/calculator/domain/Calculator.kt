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
                    result = operator.calculate(result, Character.getNumericValue(it).toFloat())
                } else {
                    operator = Operator.getOperator(it.toString())
                }
            }
        }
        return result
    }
}