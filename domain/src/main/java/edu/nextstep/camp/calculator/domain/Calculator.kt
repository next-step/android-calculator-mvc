package edu.nextstep.camp.calculator.domain

object Calculator {
    private val operandRegex = "[0-9]+".toRegex()

    fun evaluate(rawExpression: String): Float {
        var result = 0f
        var operator = Operator.NONE

        if (rawExpression.isEmpty()) throw IllegalArgumentException("exception data")
        val rawArray = rawExpression.split(" ")
        if (!operandRegex.matches(rawArray.last())) throw IllegalArgumentException("exception data")
        rawArray.forEach {
            if (operandRegex.matches(it)) {
                result = operator.calculate(result, it.toFloat())
            } else {
                operator = Operator.getOperator(it)
            }
        }
        return result
    }
}