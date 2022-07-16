package edu.nextstep.camp.calculator.domain

@JvmInline
value class Operand(val value: Double) {

    constructor(value: Int) : this(value.toDouble())

    operator fun plus(target: Operand): Operand =
        Operand(value + target.value)

    operator fun minus(target: Operand): Operand =
        Operand(value - target.value)

    operator fun times(target: Operand): Operand =
        Operand(value * target.value)

    operator fun div(target: Operand): Operand =
        Operand(value / target.value)

    companion object {
        fun of(raw: String): Operand = Operand(raw.toDouble())
    }
}
