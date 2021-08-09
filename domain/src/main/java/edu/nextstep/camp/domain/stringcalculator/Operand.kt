package edu.nextstep.camp.domain.stringcalculator

/**
 * Created By Malibin
 * on 7월 27, 2021
 */

data class Operand(
    val value: Int,
) : ExpressionToken {
    constructor(stringValue: String) : this(stringValue.toInt())

    operator fun plus(other: Operand): Operand = Operand(this.value + other.value)

    operator fun minus(other: Operand): Operand = Operand(this.value - other.value)

    operator fun times(other: Operand): Operand = Operand(this.value * other.value)

    operator fun div(other: Operand): Operand = Operand(this.value / other.value)

    override fun toString(): String = "$value"

    fun addLast(operand: Operand): Operand {
        return Operand("$this$operand")
    }

    fun removeLast(): Operand? {
        val removedValue = (this.value / 10)
        return if (removedValue == 0) null
        else Operand(removedValue)
    }
}
