package edu.nextstep.camp.calculator.domain


internal sealed class Expression {
    internal data class Calculation(
        private val expression1: Expression,
        private val expression2: Expression,
        private val operator: Operator
    ) : Expression() {
        override fun execute(): Int = operator.operate(expression1.execute(), expression2.execute())
    }

    internal data class Value(
        private val value: Int
    ) : Expression() {
        override fun execute(): Int = value
    }

    abstract fun execute(): Int
}
