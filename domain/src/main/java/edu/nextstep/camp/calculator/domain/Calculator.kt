package edu.nextstep.camp.calculator.domain

object Calculator {

    fun evaluate(expression: String?) = run {
        val chunks = ExpressionParser.parse(expression)
        val firstDigit = chunks.head().toInt()
        val remainChunks = chunks.tail()

        remainChunks.chunked(2)
            .map(BinaryCalculator::of)
            .fold(firstDigit) { acc, binaryCalculator -> binaryCalculator.evaluate(acc) }
    }
}