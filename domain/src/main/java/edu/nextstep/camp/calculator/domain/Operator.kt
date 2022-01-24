package edu.nextstep.camp.calculator.domain

enum class Operator(
    val operator: String?,
    val operatorFunc: (Float, Float) -> Float
): OperatorFactory {
    PLUS("+", {a, b -> a + b}),
    MINUS("-", {a, b -> a - b}),
    MULTIPLY("×", {a, b -> a * b}),
    DIVIDE("÷", {a, b -> a / b}),
    NONE(null, { _, b -> b});

    override fun calculate(first: Float, second: Float): Float {
        return operatorFunc(first, second)
    }

    companion object {
        fun getOperator(operator: String): Operator =
            values().find { it.operator == operator }
                ?: throw IllegalArgumentException("exception operator")

    }
}