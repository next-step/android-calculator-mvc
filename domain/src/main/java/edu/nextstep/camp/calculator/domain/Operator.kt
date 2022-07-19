package edu.nextstep.camp.calculator.domain

enum class Operator(val operator: String, val calculate: (Int, Int) -> Int) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    DIVISION("/", { first, second ->
        if (first == 0 || second == 0) {
            throw IllegalArgumentException()
        } else {
            first / second
        }
    }),
    MULTIPLICATION("*", { first, second -> first * second });

    companion object {
        fun find(operator: String) = values().find {
            it.operator == operator
        } ?: throw IllegalArgumentException()

        fun isOperator(value: String): Boolean {
            return try {
                find(value)
                true
            } catch (e: IllegalArgumentException) {
                false
            }
        }

    }
}