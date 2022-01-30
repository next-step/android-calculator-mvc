package com.manjee.domain

enum class Operator {
    PLUS {
        override fun calculate(num1: Int, num2: Int) = num1 + num2
    },
    MINUS {
        override fun calculate(num1: Int, num2: Int) = num1 - num2
    },
    MULTIPLE {
        override fun calculate(num1: Int, num2: Int) = num1 * num2
    },
    DIVIDE {
        override fun calculate(num1: Int, num2: Int) : Int {
            require(num2 != 0) {
                "값을 0으로 나눌 수 없음"
            }
            return num1 / num2
        }
    };

    companion object {
        fun isOperatorType(text: String): Operator {
            return when (text) {
                "+" -> PLUS
                "-" -> MINUS
                "/" -> DIVIDE
                "*" -> MULTIPLE
                else -> throw IllegalArgumentException("허용하지 않는 연산자입니다 (현재 연산자: $text)")
            }
        }
    }

    abstract fun calculate(num1: Int, num2: Int): Int
}