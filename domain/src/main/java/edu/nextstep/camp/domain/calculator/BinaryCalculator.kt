package edu.nextstep.camp.domain.calculator

import java.lang.IllegalArgumentException

typealias CalculationStrategy = (Int, Int) -> Int

enum class Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE
}

internal class BinaryCalculator private constructor(private val calculationStrategy: CalculationStrategy) {

    fun calculate(operator1: Int, operator2: Int) = calculationStrategy(operator1, operator2)

    companion object {
        fun searchOperator(token: String) = BinaryCalculator(setCalculationStrategy(matchOperator(token)))

        fun setCalculationStrategy(token: Operator): CalculationStrategy = when (token) {
            Operator.PLUS -> { x, y -> x + y }
            Operator.MINUS -> { x, y -> x - y }
            Operator.MULTIPLY -> { x, y -> x * y }
            Operator.DIVIDE -> { x, y -> x / y }
        }

        private fun matchOperator(token: String): Operator = when(token) {
            "+" -> Operator.PLUS
            "-" -> Operator.MINUS
            "×" -> Operator.MULTIPLY
            "÷" -> Operator.DIVIDE
            else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다")
        }
    }
}