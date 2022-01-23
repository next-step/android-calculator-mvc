package edu.nextstep.camp.calculator.domain

internal class Calculator(private val expressionParser: ExpressionParser) {

    fun evaluate(expression: String?): String {
        val chunks = expressionParser.parse(expression)
        val firstDigit = chunks.first().toInt()
        val remainChunks = chunks.drop(1)

        return remainChunks.chunked(2)
            .fold(firstDigit) { acc, (token, digit) -> BinaryCalculator.of(token).evaluate(acc, digit.toInt()) }
            .toString()
    }
}

