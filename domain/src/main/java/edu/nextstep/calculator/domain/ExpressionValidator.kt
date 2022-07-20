package edu.nextstep.calculator.domain

object ExpressionValidator {
    private val expressionRegex = Regex("-?\\d+( [+\\-*/] -?\\d+)*")
    private val numberRegex = Regex("-?\\d+")
    private val operatorRegex = Regex("[+\\-*/]")

    fun isValidExpression(expression: String) {
        require(expression.matches(expressionRegex)) {
            "올바른 수식이 아닙니다"
        }
    }

    fun isNumber(content: String?): Boolean {
        content ?: return false

        return numberRegex.matches(content)
    }

    fun isOperator(content: String?): Boolean {
        content ?: return false

        return operatorRegex.matches(content)
    }
}
