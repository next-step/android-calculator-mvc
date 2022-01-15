package edu.nextstep.camp.calculator.domain

private const val DELIMITER = " "

typealias Chunks = List<String>

fun Chunks.head() = this.first()
fun Chunks.tail() = this.drop(1)

internal object ExpressionParser {

    fun parse(expression: String?): Chunks {
        require(requireNotNull(expression).isNotBlank())
        return expression.trim().split(DELIMITER)
    }
}
