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
        fun getOperatorType(text: String): Operator {
            return when (text) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLE
                else -> DIVIDE
            }
        }

        fun isOperatorType(text: String): Boolean {
            return text == "+" || text == "-" || text == "*" || text == "/"
        }
    }

    abstract fun calculate(num1: Int, num2: Int): Int
}