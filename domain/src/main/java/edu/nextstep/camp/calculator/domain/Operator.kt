package edu.nextstep.camp.calculator.domain

internal enum class Operator(
    private val symbol: String,
    val operate: (Int, Int) -> Int
) : Token {

    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun get(symbol: String): Operator = values().find { it.symbol == symbol }
            ?: throw IllegalArgumentException("operator $symbol is not arithmetic operation") // 사칙연산 기호가 아닌 경우 IllegalArgumentException
    }
}
