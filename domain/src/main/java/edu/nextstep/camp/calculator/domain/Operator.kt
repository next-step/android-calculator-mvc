package edu.nextstep.camp.calculator.domain

enum class Operator(
    val code: String,
    val operateFun: (Double, Double) -> Double,
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> a / b });

    fun calculate(first: Double, second: Double): Double {
        if (this == DIVISION && second.isZero()) {
            throw IllegalArgumentException("Can not DIVISION Zero")
        }
        return operateFun(first, second)
    }

    companion object {
        fun getOperator(code: String): Operator =
            values().find { it.code == code } ?: throw IllegalArgumentException("Unknown Operator")

        fun getOperatorCodes() = values().map { it.code }
    }
}

internal fun Double.isZero() = this == 0.0
