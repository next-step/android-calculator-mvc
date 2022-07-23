package edu.nextstep.camp.calculator.domain


internal sealed class Expression {
    internal data class Calculation(
        private val expression1: Expression,
        private val expression2: Expression,
        private val operator: Operator
    ) : Expression() {
        override fun excute(): Int = operator.operate(expression1.excute(), expression2.excute())
    }

    internal data class Value(
        private val value: Int
    ) : Expression() {
        override fun excute(): Int = value
    }

    abstract fun excute(): Int
}
