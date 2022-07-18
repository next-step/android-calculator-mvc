package edu.nextstep.camp.calculator.domain

sealed interface Node

enum class Operator(val symbol: String, val calculate: (Int, Int) -> Int) : Node {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    DIVIDE("/", { left, right -> left / right });

    companion object {
        fun getFrom(token: String): Operator {
            return values().find { it.symbol == token }
                ?: throw IllegalArgumentException("+,-,*,/ 외에 다른 문자는 허용되지 않습니다. -> $token")
        }
    }
}

data class Operand(
    val value: Int
) : Node