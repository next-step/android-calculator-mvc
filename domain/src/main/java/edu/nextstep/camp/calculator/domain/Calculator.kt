package edu.nextstep.camp.calculator.domain

internal class Calculator {
    private val parser = Parser()

    internal fun evaluate(tokens: List<Token>): Int {
        val exp = parser.parse(tokens)
        return exp.evaluate()
    }
}
