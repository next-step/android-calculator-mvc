package edu.nextstep.camp.calculator.domain

class CalculatorDisplayModel {

    private val tokenizer = Tokenizer()
    private var expression = ""
    private val tokens get() = tokenizer.tokenize(expression)
    val state
        get() = tokens.joinToString(
            separator = " ",
            transform = {
                when (it) {
                    is Operand -> it.number.toString()
                    is Operator -> it.symbol
                }
            }
        )

    fun put(number: Int) {
        require(number in 0..9) { "Invalid number $number, must be between 0 and 9." }
        expression += number
    }

    fun put(op: String) {
        if (expression.isEmpty()) return
        if (expression.last().isDigit()) expression += op
        else if (expression.last() in Operator.values().map { it.symbol[0] }) {
            expression = expression.dropLast(1) + op
        }
        Operator.values().map { it.symbol }
    }

    fun delete() {
        expression = expression.dropLast(1)
    }

    fun calculate() {
        val calculator = Calculator()
        val result = calculator.evaluate(tokens)
        expression = result.toString()
    }
}
