package edu.nextstep.camp.calculator.domain

class Calculator {
    private val tokenizer = Tokenizer()
    private val parser = Parser()

    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("expression must not be null")
        }

        val tokens = tokenizer.tokenize(expression)
        val exp = parser.parse(tokens)
        return exp.evaluate()
    }
}
