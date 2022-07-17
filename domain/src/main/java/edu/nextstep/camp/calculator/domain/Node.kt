package edu.nextstep.camp.calculator.domain

sealed class Node

data class Operator(val symbol: String): Node() {

    fun calculate(left: Int, right: Int): Int {
        return when(symbol) {
            "+" -> left + right
            "-" -> left - right
            "*" -> left * right
            "/" -> left / right
            else -> throw IllegalArgumentException("+,-,*,/ 외에 다른 문자는 허용되지 않습니다. -> $symbol")
        }
    }
}

data class Operand(
    val value: Int
    ): Node()