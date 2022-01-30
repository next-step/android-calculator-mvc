package com.manjee.domain

enum class FormulaType {
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
            if (num2 == 0) {
                throw IllegalArgumentException("값을 0으로 나눌 수 없음")
            }
            return num1 / num2
        }
    };

    companion object {
        fun getFormulaType(formula: String): FormulaType {
            return when (formula) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLE
                else -> DIVIDE
            }
        }

        fun isFormulaType(text: String): Boolean {
            return text == "+" || text == "-" || text == "*" || text == "/"
        }
    }

    abstract fun calculate(num1: Int, num2: Int): Int
}