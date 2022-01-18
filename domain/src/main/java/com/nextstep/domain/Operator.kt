package com.nextstep.domain

enum class Operator(val operator: String) {
    ADD("+") {
        override fun eval(num1: Int, num2: Int) = num1 + num2
    },
    SUBTRACT("-") {
        override fun eval(num1: Int, num2: Int) = num1 - num2
    },
    MULTIPLY("*") {
        override fun eval(num1: Int, num2: Int) = num1 * num2
    },
    DIVIDE("/") {
        override fun eval(num1: Int, num2: Int): Int {
            if (num2 == 0) throw ArithmeticException(IS_NOT_DIVIDE_BY_ZERO)
            return num1 / num2
        }
    };

    abstract fun eval(num1: Int, num2: Int): Int

    companion object {
        const val IS_NOT_DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다."
    }
}
