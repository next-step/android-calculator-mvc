package edu.nextstep.camp.domain

typealias Chunks = List<String>

object Calculator {

    fun evaluate(expression: String?, delimiter: String): Int {
        val chunks = splitExpression(expression, delimiter)
        var acc = chunks.first().toInt()
        val restChunks = chunks.drop(1)

        restChunks.chunked(2).forEach {
            val binaryOperator = BinaryCalculator.searchOperator(it.first())
            acc = binaryOperator.calculate(acc, it.last().toInt())
        }

        return acc
    }

    fun splitExpression(expression: String?, delimiter: String): Chunks {
        require(expression.isNullOrBlank().not()) { "입력값이 null 이거나 빈 공백 문자입니다" }
        return expression?.trim()?.split(delimiter) ?: throw IllegalArgumentException()
    }
}