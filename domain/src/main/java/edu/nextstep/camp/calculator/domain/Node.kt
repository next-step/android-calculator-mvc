package edu.nextstep.camp.calculator.domain

interface Node {

}

enum class Operator(val calculate: (Int, Int) -> Int): Node {
    PLUS(
        { left: Int, right: Int -> left + right }
    ),
    MINUS(
        { left: Int, right: Int -> left - right}
    ),
    MULTIPLY(
        { left: Int, right: Int -> left * right}
    ),
    DIVIDE(
        { left: Int, right: Int -> left / right}
    );

    companion object {
        fun getFrom(token: String): Operator {
            return when(token) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("+,-,*,/ 외에 다른 문자는 허용되지 않습니다. -> $token")
            }
        }
    }
}

data class Operand(
    val value: Int
    ): Node