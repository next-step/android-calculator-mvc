package edu.nextstep.camp.calculator.domain

object Calculator {

    fun evaluate(expression: String?, delimiter: String): Int {
        val chunks = ExpressionParser.parse(expression, delimiter)
        val firstDigit = chunks.first().toInt()
        val remainChunks = chunks.drop(1)

        return remainChunks.chunked(2)
            .fold(firstDigit) { acc, (token, digit) -> BinaryCalculator.of(token).evaluate(acc, digit.toInt()) }
    }
}