package edu.nextstep.calculator.domain

enum class Operator(val value: String) {
    PLUS("+") {
        override fun calculate(first: Int, second: Int): Int = first + second
    },
    MINUS("-") {
        override fun calculate(first: Int, second: Int): Int = first - second
    },
    MULTIPLY("*") {
        override fun calculate(first: Int, second: Int): Int = first * second
    },
    DIVIDE("/") {
        override fun calculate(first: Int, second: Int): Int = first / second
    },

    UNDEFINED("UNDEFINED") {
        override fun calculate(first: Int, second: Int): Int = first
    };

    abstract fun calculate(first: Int, second: Int): Int

    companion object {
        fun fromValue(value: String): Operator? = values().associateBy(Operator::value)[value]
    }
}
