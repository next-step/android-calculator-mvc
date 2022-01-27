package com.example.domain

sealed class Operator(val symbol: Char) {
    object Plus : Operator('+') {
        override fun operate(first: Int, second: Int): Int = first + second
    }

    object Minus : Operator('-') {
        override fun operate(first: Int, second: Int): Int = first - second
    }

    object Multiply : Operator('*') {
        override fun operate(first: Int, second: Int): Int = first * second
    }

    object Divide : Operator('/') {
        override fun operate(first: Int, second: Int): Int {
            if (first == 0) throw IllegalArgumentException(CANT_DIVIDE)
            return first / second
        }
    }

    abstract fun operate(first: Int, second: Int): Int

    companion object {
        const val CANT_DIVIDE = "0을 나눌수가 없습니다"
        const val CANT_EXIST_OPERATOR = "존재 하지 않는 연산자 입니다"


        fun findOperator(operator: Char) =
            Operator::class.sealedSubclasses
                .map { it.objectInstance as Operator }
                .firstOrNull { it.symbol == operator }
                .let { symbol ->
                    when (symbol) {
                        null -> throw IllegalArgumentException(CANT_EXIST_OPERATOR)
                        else -> symbol
                    }
                }
    }

}

