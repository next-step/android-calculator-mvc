package com.nextstep.domain

enum class Operator(val symbol:String) {
    PLUS("+"),
    MULTIPLE("*"),
    MINUS("-"),
    DIVIDE("/");

    companion object {
        private const val ERROR_MESSAGE_INVALID_SYMBOL = "입력한 파라메터는 유효하지 않은 연산자 기호입니다."
        fun fromSymbol(symbol: String): Operator {
            return values().find { operator -> operator.symbol == symbol } ?: throw IllegalArgumentException(ERROR_MESSAGE_INVALID_SYMBOL)
        }
    }
}

fun Operator.calculate(leftNum: Double, rightNum: Double): Double {
    return when(this) {
        Operator.PLUS -> leftNum + rightNum
        Operator.MULTIPLE -> leftNum * rightNum
        Operator.MINUS -> leftNum - rightNum
        Operator.DIVIDE -> leftNum / rightNum
    }
}