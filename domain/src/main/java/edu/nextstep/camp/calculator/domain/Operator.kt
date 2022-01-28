package edu.nextstep.camp.calculator.domain

enum class Operator(
    val operator: String?,
    val operatorFunc: (Float, Float) -> Float
) : OperatorAction {
    PLUS("+", { operand1, operand2 -> operand1 + operand2 }),
    MINUS("-", { operand1, operand2 -> operand1 - operand2 }),
    MULTIPLY("×", { operand1, operand2 -> operand1 * operand2 }),
    DIVIDE("÷", { operand1, operand2 -> operand1 / operand2 }),
    NONE(null, { _, operand2 -> operand2 });

    override fun calculate(first: Float, second: Float): Float {
        return operatorFunc(first, second)
    }

    companion object {
        fun getOperator(operator: String): Operator =
            values().find { it.operator == operator }
                ?: throw IllegalArgumentException("exception operator")
    }
}