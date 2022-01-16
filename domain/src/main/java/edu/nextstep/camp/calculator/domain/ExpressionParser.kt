package edu.nextstep.camp.calculator.domain

typealias Chunks = List<String>

fun Chunks.head() = this.first()
fun Chunks.tail() = this.drop(1)

internal object ExpressionParser {

    fun parse(expression: String?, delimiter: String): Chunks {
        require(expression.isNullOrBlank().not())
        return expression?.trim()?.split(delimiter) ?: throw IllegalArgumentException()
    }
}
