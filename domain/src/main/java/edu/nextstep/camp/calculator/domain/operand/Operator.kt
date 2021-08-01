package edu.nextstep.camp.calculator.domain.operand

enum class Operator(
    val code: String,
    val operateFun: (Double, Double) -> Double,
) : Operand {
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

    override fun toString(): String {
        return this.code
    }

    companion object {
        fun getOperator(code: String): Operator =
            values().find { it.code == code } ?: throw IllegalArgumentException("Unknown Operator")

        fun getOperatorCodes() = values().map { it.code }
    }
}

internal fun Double.isZero() = this == 0.0
