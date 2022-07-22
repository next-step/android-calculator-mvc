package edu.nextstep.camp.calculator.domain

@JvmInline
value class Operand(private val value: String) : Operational {
    fun lastValueDropped():Operand =  Operand(value.dropLast(1))

    override fun isRemoveAble(): Boolean = value.length == 1

    override fun isOperand(): Boolean = true

    override fun toString(): String = value

    companion object {
        private val operandRange: CharRange = '0'..'9'

        fun isOperandValue(c: Char): Boolean = c in operandRange
    }
}