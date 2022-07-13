package edu.nextstep.camp.calculator.domain

sealed interface Symbol {

    data class Number(val n: Int) : Symbol {

        operator fun plus(other: Number) = Number(n + other.n)
        operator fun minus(other: Number) = Number(n - other.n)
        operator fun times(other: Number) = Number(n * other.n)
        operator fun div(other: Number) = Number(n / other.n)
    }

    enum class Sign : Symbol {
        PLUS,
        MINUS,
        TIMES,
        DIVISION,
    }
}
