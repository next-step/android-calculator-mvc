package com.example.domain

import java.lang.IllegalArgumentException

typealias Operator = (Int, Int) -> Int

internal class BinaryCalculator private constructor(private val operator: Operator) {

    fun calculate(operator1: Int, operator2: Int) = operator.invoke(operator1, operator2)

    companion object {
        fun searchOperator(token: String) = BinaryCalculator(operator(token))

        private fun operator(token: String): Operator = when (token) {
            "+" -> { x, y -> x + y }
            "-" -> { x, y -> x - y }
            "*" -> { x, y -> x * y }
            "/" -> { x, y -> x / y }
            else -> throw IllegalArgumentException()
        }
    }
}