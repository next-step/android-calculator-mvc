package com.example.domain

typealias Chunks = List<String>

object Calculator {

    fun evaluate(expression: String?, delimiter: String): Int {
        val chunks = splitExpression(expression, delimiter)
        val initial = chunks.first().toInt()
        val restChunks = chunks.drop(1)

        return restChunks.chunked(2).fold(initial) {
            acc, (token, operand) -> BinaryCalculator.searchOperator(token).calculate(acc, operand.toInt())
        }
    }

    fun splitExpression(expression: String?, delimiter: String): Chunks {
        require(expression.isNullOrBlank().not())
        return expression?.trim()?.split(delimiter) ?: throw IllegalArgumentException()
    }
}