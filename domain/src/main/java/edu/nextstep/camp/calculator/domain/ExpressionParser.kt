package edu.nextstep.camp.calculator.domain

typealias Chunks = List<String>

internal class ExpressionParser(private val delimiter: String) {

    fun parse(expression: String?): Chunks {
        require(!expression.isNullOrBlank())
        return expression.trim().split(delimiter)
    }
}
