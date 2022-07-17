package edu.nextstep.calculator.domain

object ExpressionValidation {
    private val expressionRegex = Regex("-?\\d+( [+\\-*/] -?\\d+)*")

    fun isValidExpression(expression: String) {
        require(expression.matches(expressionRegex)) {
            "올바른 수식이 아닙니다"
        }
    }
}
