package edu.nextstep.camp.calculator.domain

class Calculator {
    private val tokenizer = Tokenizer()
    private val parser = Parser()

    fun evaluate(expression: String?): Int {
        require(!expression.isNullOrBlank()) { "expression must not be null" }
        val tokens = tokenizer.tokenize(expression)
        val exp = parser.parse(tokens)
        return exp.evaluate()
    }
}
