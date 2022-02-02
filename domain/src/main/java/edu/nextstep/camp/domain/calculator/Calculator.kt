package edu.nextstep.camp.domain.calculator

import edu.nextstep.camp.domain.expression.ExpressionParser

internal class Calculator(private val expressionParser: ExpressionParser) {

    fun evaluate(expression: String?): String {
        val chunks = expressionParser.splitExpression(expression)
        var acc = chunks.first().toInt()
        val restChunks = chunks.drop(1)

        restChunks.chunked(2).forEach {
            val binaryOperator = BinaryCalculator.searchOperator(it.first())
            acc = binaryOperator.calculate(acc, it.last().toInt())
        }

        return acc.toString()
    }
}