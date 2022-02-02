package edu.nextstep.camp.domain.calculator

import java.lang.IllegalArgumentException

typealias Operator = (Int, Int) -> Int

enum class Op {
    PLUS, MINUS, MULTIPLY, DIVIDE
}

internal class BinaryCalculator private constructor(private val operator: Operator) {

    fun calculate(operator1: Int, operator2: Int) = operator(operator1, operator2)

    companion object {
        fun searchOperator(token: String) = BinaryCalculator(operator(matchOp(token)))

        fun operator(token: Op): Operator = when (token) {
            Op.PLUS -> { x, y -> x + y }
            Op.MINUS -> { x, y -> x - y }
            Op.MULTIPLY -> { x, y -> x * y }
            Op.DIVIDE -> { x, y -> x / y }
        }

        private fun matchOp(token: String): Op = when(token) {
            "+" -> Op.PLUS
            "-" -> Op.MINUS
            "×" -> Op.MULTIPLY
            "÷" -> Op.DIVIDE
            else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다")
        }
    }
}