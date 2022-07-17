package edu.nextstep.camp.calculator.domain

class Calculator {
    private val parser = Parser()

    fun evaluate(tokens: List<Token>): Int {
        val exp = parser.parse(tokens)
        return exp.evaluate()
    }
}
