package edu.nextstep.camp.caculator.domain

sealed class ExpressionData {
    data class Essence(val essence: Int): ExpressionData()
    data class Sum(val expression1: ExpressionData, val expression2: ExpressionData): ExpressionData()
    data class Subtract(val expression1: ExpressionData, val expression2: ExpressionData): ExpressionData()
    data class Divide(val expression1: ExpressionData, val expression2: ExpressionData): ExpressionData()
    data class Multiply(val expression1: ExpressionData, val expression2: ExpressionData): ExpressionData()
    object NaN: ExpressionData()
}
