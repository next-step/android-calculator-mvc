package edu.nextstep.camp.calculator.domain

internal data class Expression(
    private val operand1: Int,
    private val operand2: Int,
    private val operator: Operator,
) {
    fun expose(): Int = operator.operate(operand1, operand2)
}

