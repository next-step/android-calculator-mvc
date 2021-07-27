package edu.nextstep.camp.domain.stringcalculator

/**
 * Created By Malibin
 * on 7월 22, 2021
 */

enum class Operator(
    private val token: String,
    private val calculateStrategy: (Int, Int) -> Int
) : ExpressionToken {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    DIVIDE("/", { left, right -> left / right });

    fun calculate(left: Int, right: Int): Int {
        return calculateStrategy(left, right)
    }

    companion object {
        fun find(token: String): Operator = values().find { it.token == token }
            ?: throw IllegalArgumentException("$token 을 가진 연산자를 찾을 수 없습니다.")
    }
}
