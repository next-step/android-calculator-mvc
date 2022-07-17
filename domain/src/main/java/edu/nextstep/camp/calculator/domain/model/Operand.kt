package edu.nextstep.camp.calculator.domain.model

@JvmInline
value class Operand(val value: Int)  {
    operator fun plus(other: Operand) = Operand(value + other.value)
    operator fun minus(other: Operand) = Operand(value - other.value)
    operator fun times(other: Operand) = Operand(value * other.value)
    operator fun div(other: Operand) = Operand(value / other.value)
}
