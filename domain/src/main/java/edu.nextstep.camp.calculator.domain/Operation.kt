package edu.nextstep.camp.calculator.domain

sealed interface Operation {

    val symbol: String

    fun run(first: Number, second: Number): Number

    object Plus : Operation {
        override val symbol = "+"
        override fun run(first: Number, second: Number): Number =
            first + second
    }

    companion object {
        fun of(raw: String): Operation = when (raw) {
            Plus.symbol -> Plus
            else -> TODO()
        }
    }
}
