package com.example.domain

import com.example.domain.Operator.Divide.operate


sealed class Operator(val symbol: Char, val calculateStrategy: (Int, Int) -> Int) {
    object Plus : Operator('+', { left: Int, right: Int -> left + right })

    object Minus : Operator('-', { left: Int, right: Int -> left - right })

    object Multiply : Operator('*', { left: Int, right: Int -> left * right })

    object Divide : Operator('/', { left: Int, right: Int -> operate(left, right) }) {
        fun operate(left: Int, right: Int): Int{
            if (left == 0) throw IllegalArgumentException(CANT_DIVIDE)
            return left / right
        }
    }



    companion object {
        const val CANT_DIVIDE = "0을 나눌수가 없습니다"
        const val CANT_EXIST_OPERATOR = "존재 하지 않는 연산자 입니다"


        fun find(symbol: Char): Operator {
            return when (symbol) {
                Plus.symbol -> Plus
                Minus.symbol -> Minus
                Multiply.symbol -> Multiply
                Divide.symbol -> Divide
                else -> {
                    throw IllegalArgumentException(CANT_EXIST_OPERATOR)
                }
            }
        }
    }

}

