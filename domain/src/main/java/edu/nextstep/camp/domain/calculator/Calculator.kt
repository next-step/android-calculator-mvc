package edu.nextstep.camp.domain.calculator

import edu.nextstep.camp.domain.expression.ExpressionProcessor

internal class Calculator(private val expressionProcessor: ExpressionProcessor) {

    fun evaluate(expression: String?): String {
        val chunks = expressionProcessor.splitExpression(expression)
        var acc = chunks.first().toInt()
        val restChunks = chunks.drop(1)

        restChunks.chunked(2).forEach {
            val binaryOperator = BinaryCalculator.searchOperator(it.first())
            acc = binaryOperator.calculate(acc, it.last().toInt())
        }

        return acc.toString()
    }
}