package edu.nextstep.camp.domain.calculator

import java.lang.IllegalArgumentException

typealias CalculationStrategy = (Int, Int) -> Int

enum class Formula(val operator: String, val formula: CalculationStrategy) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("×", { x, y -> x * y }),
    DIVIDE("÷", { x, y -> x / y });

    companion object {
        fun matchFormula(token: String): CalculationStrategy = when(token) {
            PLUS.operator -> PLUS.formula
            MINUS.operator -> MINUS.formula
            MULTIPLY.operator -> MULTIPLY.formula
            DIVIDE.operator -> DIVIDE.formula
            else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다")
        }
    }
}

internal class BinaryCalculator private constructor(private val calculationStrategy: CalculationStrategy) {

    fun calculate(operator1: Int, operator2: Int) = calculationStrategy(operator1, operator2)

    companion object {
        fun searchOperator(token: String) = BinaryCalculator(Formula.matchFormula(token))
    }
}