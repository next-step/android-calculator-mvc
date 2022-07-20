package edu.nextstep.camp.calculator.domain

enum class Operator(
    val symbol: String,
    val action: (Operand, Operand) -> Operand
) : Term {

    PLUS(symbol = "+", action = { first, second -> first + second }),
    MINUS(symbol = "-", action = { first, second -> first - second }),
    MULTIPLY(symbol = "*", action = { first, second -> first * second }),
    DIVIDE(symbol = "/", action = { first, second -> first / second });

    override fun toString(): String = symbol

    companion object {
        fun of(raw: String): Operator =
            values()
                .find { it.symbol == raw }
                ?: throw IllegalArgumentException("${raw}에 해당하는 Operator를 찾을 수 없습니다.")
    }
}

