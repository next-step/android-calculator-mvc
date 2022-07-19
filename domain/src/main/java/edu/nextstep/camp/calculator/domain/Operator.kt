package edu.nextstep.camp.calculator.domain

internal enum class Operator(private val symbol: String) : Token {

    PLUS("+") {
        override fun operate(a: Int, b: Int) = a + b
    },
    MINUS("-") {
        override fun operate(a: Int, b: Int) = a - b
    },
    MULTIPLY("*") {
        override fun operate(a: Int, b: Int) = a * b
    },
    DIVIDE("/") {
        override fun operate(a: Int, b: Int) = a / b
    };

    abstract fun operate(a: Int, b: Int): Int

    companion object {
        fun get(value: String): Operator = values().find { it.symbol == value }
            ?: throw IllegalArgumentException() // 사칙연산 기호가 아닌 경우 IllegalArgumentException
    }
}
