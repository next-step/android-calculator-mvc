package edu.nextstep.camp.calculator.domain

@JvmInline
value class Operand(val value: Double) : Term {

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
        fun of(raw: String): Operand =
            Operand(raw.toDoubleOrNull() ?: throw IllegalArgumentException("${raw}에 해당하는 Operand를 찾을 수 없습니다."))
    }
}
