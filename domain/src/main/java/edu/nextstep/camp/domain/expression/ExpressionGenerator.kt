package edu.nextstep.camp.domain.expression

internal class ExpressionGenerator(private val joinDelimiter: String) {
    private val expression = Expression()

    fun append(symbol: String) = apply {
        when {
            isDigit(symbol) -> processDigit(symbol)
            else -> processOperator(symbol)
        }
    }

    fun delete() = apply {
        processDelete()
    }

    fun update(symbol: String) = apply {
        expression.clearBy(symbol)
    }

    private fun isDigit(symbol: String) = symbol.toIntOrNull() != null

    fun isValid() = expression.isValid()

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

    private fun processDelete() = with(expression) {
        when {
            isEmpty() -> {}
            else -> expression.removeLast()
        }
    }

    fun generate() = expression.generate(joinDelimiter)
}