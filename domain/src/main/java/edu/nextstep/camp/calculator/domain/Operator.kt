package edu.nextstep.camp.calculator.domain

enum class Operator(
    val operator: String?
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("×"),
    DIVIDE("÷"),
    NONE(null);

    companion object {
        fun getOperator(operator: String): Operator =
            values().find { it.operator == operator }
                ?: throw IllegalArgumentException("exception operator")

        fun plus(first: Float, second: Float): Float {
            return first + second
        }

        fun minus(first: Float, second: Float): Float {
            return first - second
        }

        fun multipliedBy(first: Float, second: Float): Float {
            return first * second
        }

        fun dividedBy(first: Float, second: Float): Float {
            return first / second
        }
    }
}