package com.nextstep.domain

enum class Operator(val symbol:String) {
    PLUS("+"),
    MULTIPLE("*");

    companion object {
        fun fromSymbol(symbol: String): Operator {
            return values().find { operator -> operator.symbol == symbol } ?: throw IllegalArgumentException()
        }
    }
}

fun Operator.calculate(leftNum: Double, rightNum: Double): Double {
    return when(this) {
        Operator.PLUS -> leftNum + rightNum
        Operator.MULTIPLE -> leftNum * rightNum
    }
}