package edu.nextstep.camp.calculator.domain

sealed interface Operation {

    val symbol: String

    fun run(first: Operand, second: Operand): Operand

    object Plus : Operation {
        override val symbol = "+"
        override fun run(first: Operand, second: Operand): Operand =
            first + second
    }

    object Minus : Operation {
        override val symbol = "-"
        override fun run(first: Operand, second: Operand): Operand =
            first - second
    }

    object Multiply : Operation {
        override val symbol = "*"
        override fun run(first: Operand, second: Operand): Operand =
            first * second
    }

    object Divide : Operation {
        override val symbol = "/"
        override fun run(first: Operand, second: Operand): Operand =
            first / second
    }

    companion object {
        fun of(raw: String): Operation = when (raw) {
            Plus.symbol -> Plus
            Minus.symbol -> Minus
            Multiply.symbol -> Multiply
            Divide.symbol -> Divide
            else -> throw IllegalArgumentException()
        }
    }
}
