package edu.nextstep.camp.calculator.domain

sealed class Operator (val value: String) : Operate {
    class Plus (value: String) : Operator(value) {
        override fun calculate(leftNumber: Number, rightNumber: Number): Number {
            return Number(leftNumber.value + rightNumber.value)
        }
    }

    class Minus (value: String) : Operator(value) {
        override fun calculate(leftNumber: Number, rightNumber: Number): Number {
            return Number(leftNumber.value - rightNumber.value)
        }
    }

    class Multiply (value: String) : Operator(value) {
        override fun calculate(leftNumber: Number, rightNumber: Number): Number {
            return Number(leftNumber.value * rightNumber.value)
        }
    }

    class Divide (value: String) : Operator(value) {
        override fun calculate(leftNumber: Number, rightNumber: Number): Number {
            return Number(leftNumber.value / rightNumber.value)
        }
    }

    override fun equals(other: Any?): Boolean {
        return this.value == (other as Operator).value
    }

    companion object {
        val OPEARATORS = listOf("+", "-", "×", "÷")
        fun of(value: String): Operator {
            return when(value) {
                "+" -> { Plus(value) }
                "-" -> { Minus(value) }
                "×" -> { Multiply(value) }
                "÷" -> { Divide(value) }
                else -> throw IllegalArgumentException("올바른 연산자가 아닙니다")
            }
        }

        fun isOperator(value :String): Boolean {
            return OPEARATORS.contains(value)
        }
    }
}
