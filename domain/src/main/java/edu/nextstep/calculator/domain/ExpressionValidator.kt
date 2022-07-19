package edu.nextstep.calculator.domain

object ExpressionValidator {
    private val expressionRegex = Regex("-?\\d+( [+\\-*/] -?\\d+)*")
    private val numberRegex = Regex("-?\\d+")

    fun isValidExpression(expression: String) {
        require(expression.matches(expressionRegex)) {
            "올바른 수식이 아닙니다"
        }
    }

    fun isNumber(content: String?): Boolean {
        content ?: return false

        return numberRegex.matches(content)
    }
}
