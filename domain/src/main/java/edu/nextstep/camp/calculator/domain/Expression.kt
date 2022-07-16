package edu.nextstep.camp.calculator.domain

internal interface Expression {
    fun evaluate(): Int
}

internal data class ExpressionNode(
    private val left: Expression,
    private val right: Expression,
    private val op: Operator
) : Expression {
    override fun evaluate(): Int {
        val a = left.evaluate()
        val b = right.evaluate()
        return op.operate(a, b)
    }
}

internal data class ValueNode(
    private val value: Int
) : Expression {
    override fun evaluate(): Int {
        return value
    }
}
