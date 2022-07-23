package edu.nextstep.camp.calculator.domain


internal sealed class Expression {
    internal data class Calculation(
        private val operand1: Expression,
        private val operand2: Expression,
        private val operator: Operator
    ) : Expression() {
        override fun excute(): Int = operator.operate(operand1.excute(), operand2.excute())
    }

    internal data class Value(
        private val value: Int
    ) : Expression() {
        override fun excute(): Int = value
    }

    abstract fun excute(): Int
}
