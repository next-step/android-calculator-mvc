package edu.nextstep.camp.calculator.domain

enum class Operation(
    val symbol: String,
    val action: (Operand, Operand) -> Operand
) {

    PLUS(symbol = "+", action = { first, second -> first + second }),
    MINUS(symbol = "-", action = { first, second -> first - second }),
    MULTIPLY(symbol = "*", action = { first, second -> first * second }),
    DIVIDE(symbol = "/", action = { first, second -> first / second });

    companion object {
        fun of(raw: String): Operation =
            values()
                .find { it.symbol == raw }
                ?: throw IllegalArgumentException()
    }
}
