package edu.nextstep.camp.calculator.domain

typealias Chunks = List<String>

internal object ExpressionParser {

    fun parse(expression: String?, delimiter: String): Chunks {
        require(!expression.isNullOrBlank())
        return expression.trim().split(delimiter)
    }
}
