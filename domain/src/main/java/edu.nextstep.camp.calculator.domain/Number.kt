package edu.nextstep.camp.calculator.domain

@JvmInline
value class Number(val value: Double) {

    constructor(value: Int) : this(value.toDouble())

    operator fun plus(target: Number): Number =
        Number(value + target.value)

    companion object {
        fun of(raw: String): Number = Number(raw.toDouble())
    }
}
