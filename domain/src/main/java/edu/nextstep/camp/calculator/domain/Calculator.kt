package edu.nextstep.camp.calculator.domain

open class EvaluationException(message: String) : IllegalStateException(message)

internal class Calculator {
    private val parser = Parser()

    internal fun evaluate(tokens: List<Token>): Int {
        val exp = parser.parse(tokens)
        return exp.evaluate()
    }
}
