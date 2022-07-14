package edu.nextstep.calculator.domain

class Calculator {
    private val expressionContents = mutableListOf<String>()

    fun input(expression: String?) {
        require(!expression.isNullOrBlank()) {
            "입력값이 null이거나 빈 공백 문자입니다."
        }

        expressionContents.addAll(splitExpression(expression))
    }

    private fun splitExpression(expression: String): List<String> {
        return expression.split(" ")
    }

    fun plus(first: Int, second: Int): Int = first + second
    fun minus(first: Int, second: Int): Int = first - second
    fun multiply(first: Int, second: Int): Int = first * second
    fun divide(first: Int, second: Int): Int = first / second
}
