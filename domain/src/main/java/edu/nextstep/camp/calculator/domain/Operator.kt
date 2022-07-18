package edu.nextstep.camp.calculator.domain

enum class Operator(val operator: String, val calculate: (Int, Int) -> Int) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    DIVISION("/", { first, second -> first / second }),
    MULTIPLICATION("*", { first, second -> first * second });

    companion object {
        fun find(operator: String) = values().find {
            it.operator == operator
        } ?: throw IllegalArgumentException()
    }
}