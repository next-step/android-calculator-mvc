package edu.nextstep.camp.calculator.domain

data class Operator(val value: String) {

    init {
        isOperator(value)
    }

    private fun isOperator(value: String) {
        if(!OPERATORS.contains(value)) throw IllegalArgumentException("올바른 연산기호가 아닙니다")
    }

    companion object {
        const val PLUS = "+"
        const val MINUS = "-"
        const val MULTIPLY = "×"
        const val DIVIDE = "÷"
        val OPERATORS = listOf<String>("+", "-", "×", "÷")
    }
}
