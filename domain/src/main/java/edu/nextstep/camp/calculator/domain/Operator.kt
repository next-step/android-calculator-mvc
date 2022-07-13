package edu.nextstep.camp.calculator.domain

/**
 * 사칙연산자 체크 및 제한을 위한 Operator Enum class
 * Created by Jaesungchi on 2022.07.14..
 */
enum class Operator(
    val operator: String,
    val calculate: (Number, Number) -> Number
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> if (b.isZero()) throw IllegalArgumentException(CAN_NOT_DIVIDED_BY_ZERO) else a / b });

    companion object {
        fun of(operator: String): Operator = values().find { it.operator == operator }
            ?: throw IllegalArgumentException(IS_NON_OPERATOR_CHARACTER)

        private const val IS_NON_OPERATOR_CHARACTER = "연산자 위치에 올바른 연산자가 오지 않았습니다."
        private const val CAN_NOT_DIVIDED_BY_ZERO = "0으로 나눌 순 없습니다."
    }
}
