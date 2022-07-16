package edu.nextstep.camp.calculator.domain

class Calculator(
    private val expressionParser: ExpressionParser
) {

    fun evaluate(expressionString: String?): Int {
        if (expressionString.isNullOrBlank())
            throw IllegalArgumentException("null 또는 빈 공백 문자열은 수식이 아닙니다.")

        val expression = expressionParser.parse(expressionString)
        return evaluateSymbols(expression)
    }

    private fun evaluateSymbols(expression: Expression): Int {
        return expression.signList
            .zip(expression.numberList.drop(1))
            .fold(expression.numberList.first()) { prevResult, (sign, number) ->
                evaluateOne(prevResult, sign, number)
            }
    }

    private fun evaluateOne(
        prevResult: Int,
        sign: Sign,
        number: Int,
    ): Int {
        return when (sign) {
            Sign.PLUS -> prevResult + number
            Sign.MINUS -> prevResult - number
            Sign.TIMES -> prevResult * number
            Sign.DIVISION -> prevResult / number
        }
    }
}
