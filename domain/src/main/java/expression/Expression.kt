package expression

private const val MIN_SIZE_FOR_EVALUATE = 3

internal class Expression {

    private val symbols = mutableListOf<String>()

    fun isEmpty() = symbols.isEmpty()

    fun add(symbol: String) = symbols.add(symbol)

    fun removeLast() {
        val lastDigit = symbols.removeLast()

        val remainDigit = lastDigit.dropLast(1)
        if (remainDigit.isNotBlank()) {
            symbols.add(remainDigit)
        }
    }

    fun replaceLast(symbol: String) {
        removeLast()
        add(symbol)
    }

    fun isLastDigit() = symbols.lastOrNull()?.toIntOrNull() != null

    fun mergeLast(symbol: String) = symbols.add(symbols.removeLast() + symbol)

    fun clearBy(symbol: String) {
        symbols.clear()
        symbols.add(symbol)
    }

    fun isValid() = symbols.size >= MIN_SIZE_FOR_EVALUATE

    fun generate(joinDelimiter: String) = symbols.joinToString(joinDelimiter)

}