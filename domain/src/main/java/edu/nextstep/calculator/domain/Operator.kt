package edu.nextstep.calculator.domain

enum class Operator(value: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),

    UNDEFINED("UNDEFINED");

    companion object {
        fun calculateExpression(first: Int, second: Int, operation: Operator): Int {
            return when (operation) {
                PLUS -> plus(first = first, second = second)
                MINUS -> minus(first = first, second = second)
                MULTIPLY -> multiply(first = first, second = second)
                DIVIDE -> divide(first = first, second = second)
                else -> first
            }
        }

        private fun plus(first: Int, second: Int): Int = first + second
        private fun minus(first: Int, second: Int): Int = first - second
        private fun multiply(first: Int, second: Int): Int = first * second
        private fun divide(first: Int, second: Int): Int = first / second
    }
}
