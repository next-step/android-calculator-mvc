package edu.nextstep.camp.calculator.domain

enum class Operator(
    val operator: String?
): OperatorFactory {
    PLUS("+") {
        override fun calculate(first: Float, second: Float): Float {
            return first + second
        }
    },
    MINUS("-") {
        override fun calculate(first: Float, second: Float): Float {
            return first - second
        }
    },
    MULTIPLY("×") {
        override fun calculate(first: Float, second: Float): Float {
            return first * second
        }
    },
    DIVIDE("÷") {
        override fun calculate(first: Float, second: Float): Float {
            return first / second
        }
    },
    NONE(null) {
        override fun calculate(first: Float, second: Float): Float {
            return second
        }
    };

    companion object {
        fun getOperator(operator: String): Operator =
            values().find { it.operator == operator }
                ?: throw IllegalArgumentException("exception operator")

    }
}