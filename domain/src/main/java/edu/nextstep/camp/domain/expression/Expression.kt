package edu.nextstep.camp.domain.expression

private const val MIN_SIZE_FOR_EVALUATE = 3

class Expression(private val joinDelimiter: String) {

    val symbols: MutableList<String> = mutableListOf()

    fun append(symbol: String): Expression = apply {
        when {
            isDigit(symbol) -> processDigit(symbol)
            else -> processOperator(symbol)
        }
    }

    fun delete(): Expression = apply {
        processDelete()
    }

    fun update(symbol: String): Expression = apply {
        clearBy(symbol)
    }

    fun generate(): String = symbols.joinToString(joinDelimiter)

    private fun processDigit(symbol: String): Any = with(this) {
        when {
            isLastDigit() -> mergeLast(symbol)
            else -> add(symbol)
        }
    }

    private fun processOperator(symbol: String): Any = with(this) {
        when {
            isEmpty() -> {}
            isLastDigit() -> add(symbol)
            else -> replaceLast(symbol)
        }
    }

    private fun processDelete(): Any = with(this) {
        when {
            isEmpty() -> {}
            else -> removeLast()
        }
    }

    private fun add(symbol: String): Boolean = symbols.add(symbol)

    private fun removeLast(): String = symbols.removeLast()

    private fun replaceLast(symbol: String) {
        removeLast()
        add(symbol)
    }

    private fun mergeLast(symbol: String) {
        val lastSymbol = removeLast()
        symbols.add(lastSymbol + symbol)
    }

    private fun clearBy(symbol: String) {
        symbols.clear()
        symbols.add(symbol)
    }

    private fun isDigit(symbol: String): Boolean = symbol.toIntOrNull() != null

    private fun isLastDigit(): Boolean = symbols.lastOrNull()?.toIntOrNull() != null

    private fun isEmpty(): Boolean = symbols.isEmpty()

    fun isValid(): Boolean = symbols.size >= MIN_SIZE_FOR_EVALUATE
}