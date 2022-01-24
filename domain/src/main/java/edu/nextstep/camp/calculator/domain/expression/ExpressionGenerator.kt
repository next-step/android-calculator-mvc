package edu.nextstep.camp.calculator.domain.expression

internal class ExpressionGenerator(private val joinDelimiter: String) {

    private val expression = Expression()

    fun append(symbol: String) = apply {
        when {
            isDigit(symbol) -> processDigit(symbol)
            else -> processOperator(symbol)
        }
    }

    private fun isDigit(symbol: String) = symbol.toIntOrNull() != null

    private fun processDigit(symbol: String) = with(expression) {
        when {
            isLastDigit() -> mergeLast(symbol)
            else -> add(symbol)
        }
    }

    private fun processOperator(symbol: String) = with(expression) {
        when {
            isEmpty() -> {}
            isLastDigit() -> add(symbol)
            else -> replaceLast(symbol)
        }
    }

    fun delete() = apply {
        processDelete()
    }

    private fun processDelete() = with(expression) {
        when {
            isEmpty() -> {}
            else -> removeLast()
        }
    }

    fun update(symbol: String) = apply {
        expression.clearBy(symbol)
    }

    fun isValid() = expression.isValid()

    fun generate() = expression.generate(joinDelimiter)
}