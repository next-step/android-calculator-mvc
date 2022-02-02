package edu.nextstep.camp.domain.expression

private const val MIN_SIZE_FOR_EVALUATE = 3

class Expression {
    private val symbols = mutableListOf<String>()

    fun add(symbol: String) = symbols.add(symbol)

    fun removeLast() = symbols.removeLast()

    fun replaceLast(symbol: String) {
        removeLast()
        add(symbol)
    }

    fun mergeLast(symbol: String) {
        val lastSymbol = removeLast()
        symbols.add(lastSymbol + symbol)
    }

    fun clearBy(symbol: String) {
        symbols.clear()
        symbols.add(symbol)
    }

    fun isLastDigit() = symbols.lastOrNull()?.toIntOrNull() != null

    fun isEmpty() = symbols.isEmpty()

    fun isValid() = symbols.size >= MIN_SIZE_FOR_EVALUATE

    fun generate(joinDelimiter: String) = symbols.joinToString(joinDelimiter)
}