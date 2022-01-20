package com.example.domain

sealed class Operator : Calculate {
    object Plus : Operator() {
        override fun operate(first: Int, second: Int): Int = first + second
    }

    object Minus : Operator() {
        override fun operate(first: Int, second: Int): Int = first - second
    }

    object Multiply : Operator() {
        override fun operate(first: Int, second: Int): Int = first * second
    }

    object Divide : Operator() {
        override fun operate(first: Int, second: Int): Int {
            if (first == 0) throw IllegalArgumentException(CANT_DIVIDE)
            return first / second
        }
    }


    companion object {
        const val CANT_DIVIDE = "0을 나눌수가 없습니다"

        fun calculateValue(symbol: Char, left: Int, right: Int): Int {
            return when (symbol) {
                '+' -> Plus.operate(left, right)
                '-' -> Minus.operate(left, right)
                '*' -> Multiply.operate(left, right)
                '/' -> Divide.operate(left, right)
                else -> {
                    throw IllegalArgumentException()
                }
            }
        }
    }

}

interface Calculate {
    fun operate(first: Int, second: Int): Int
}


