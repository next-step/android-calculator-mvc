package edu.nextstep.camp.calculator.domain

@JvmInline
value class Number(val value: Double) {

    constructor(value: Int) : this(value.toDouble())

    operator fun plus(target: Number): Number =
        Number(value + target.value)

    operator fun minus(target: Number): Number =
        Number(value - target.value)

    operator fun times(target: Number): Number =
        Number(value * target.value)

    operator fun div(target: Number): Number =
        Number(value / target.value)

    companion object {
        fun of(raw: String): Number = Number(raw.toDouble())
    }
}
