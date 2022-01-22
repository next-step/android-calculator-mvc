package edu.nextstep.camp.calculator.domain

internal class ExpressionGenerator(private val joinDelimiter: String) {

    private val expression = Expression()

    fun append(symbol: String) = when {
        isDigit(symbol) -> processDigit(symbol)
        else -> processOperator(symbol)
    }

    private fun isDigit(symbol: String) = symbol.toIntOrNull() != null

    private fun processDigit(symbol: String) = with(expression) {
        when {
            isLastDigit() -> mergeLastDigitWith(symbol)
            else -> add(symbol)
        }

        this@ExpressionGenerator
    }

    private fun processOperator(symbol: String) = with(expression) {
        when {
            isEmpty() -> {}
            isLastDigit() -> add(symbol)
        }

        this@ExpressionGenerator
    }

    fun delete() = processDelete()

    private fun processDelete() = with(expression) {
        when {
            isEmpty() -> {}
            else -> removeLast()
        }

        this@ExpressionGenerator
    }

    fun update(symbol: String) {
        expression.clearBy(symbol)
    }

    fun isValid() = expression.isValid()

    fun generate() = expression.generate(joinDelimiter)
}