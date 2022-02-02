package edu.nextstep.camp.domain.expression

typealias Chunks = List<String>

internal class ExpressionParser(private val delimiter: String) {
    fun splitExpression(expression: String?): Chunks {
        require(expression.isNullOrBlank().not()) { "입력값이 null 이거나 빈 공백 문자입니다" }
        return expression?.trim()?.split(delimiter) ?: throw IllegalArgumentException()
    }
}