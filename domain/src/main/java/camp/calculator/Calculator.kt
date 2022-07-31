package edu.nextstep.camp.calculator.domain.camp.calculator

import camp.calculator.CalculateBinary
import expression.ExpressionParser

internal class Calculator(private val expressionParser: ExpressionParser) {

    fun evaluate(expression: String?) : String {
        val chunks = expressionParser.parse(expression)
        val firstDigit = chunks.first().toInt()
        val remainChunks = chunks.drop(1)

        return remainChunks
            .chunked(2)
            .fold(firstDigit) { acc, (token, digit) -> CalculateBinary.of(token).evaluate(acc, digit.toInt()) }
            .toString()
    }

}