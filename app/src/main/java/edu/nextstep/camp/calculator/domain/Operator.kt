package edu.nextstep.camp.calculator.domain

sealed class Operator (val value: String) {
    object Plus : Operator("+")
    object Minus : Operator("-")
    object Multiply : Operator("×")
    object Divide : Operator("÷")

    fun calculate(numberLeft: Number, numberRight: Number): Number {
        return when(this) {
            is Plus -> {
                Number(numberLeft.value + numberRight.value)
            }
            is Minus -> {
                Number(numberLeft.value - numberRight.value)
            }
            is Multiply -> {
                Number(numberLeft.value * numberRight.value)
            }
            is Divide -> {
                Number(numberLeft.value / numberRight.value)
            }
        }
    }

    companion object {
        private val operators = listOf("+", "-", "×", "÷")
        fun of(value: String): Operator {
            return when(value) {
                "+" -> { Operator.Plus }
                "-" -> { Operator.Minus }
                "×" -> { Operator.Multiply }
                "÷" -> { Operator.Divide }
                else -> throw IllegalArgumentException("올바른 연산자가 아닙니다")
            }
        }

        fun isOperator(value :String): Boolean {
            return operators.contains(value)
        }
    }
}
