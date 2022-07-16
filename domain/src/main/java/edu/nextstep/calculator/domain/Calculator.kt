package edu.nextstep.calculator.domain

class Calculator {
    private fun splitExpression(expression: String): List<String> {
        val expressionContents = expression.split(" ")
        isValidExpression(expressionContents)
        return expressionContents
    }

    private fun isValidExpression(expressionContents: List<String>) {
        expressionContents.forEachIndexed { index, content ->
            checkNumber(content, index)
            checkOperator(content, index)
        }
    }

    private fun isNumber(content: String): Boolean {
        val isIntRegex = Regex("-?\\d+")

        return content.matches(isIntRegex)
    }

    private fun checkNumber(content: String, index: Int) {
        if (index % 2 != 0) return

        require(isNumber(content)) {
            "숫자가 아닙니다"
        }
    }

    private fun checkOperator(content: String, index: Int) {
        if (index % 2 != 1) return

        require(Operator.fromValue(content) != Operator.UNDEFINED) {
            "사칙연산 기호가 아닙니다"
        }
    }

    fun calculate(expression: String?): Int {
        require(!expression.isNullOrBlank()) {
            "입력값이 null이거나 빈 공백 문자입니다."
        }

        val expressionContents = splitExpression(expression)

        var result = expressionContents.first().toInt()
        var operator = Operator.UNDEFINED
        expressionContents.forEach { content ->
            if (Operator.fromValue(content) != Operator.UNDEFINED) {
                operator = Operator.fromValue(content)
                return@forEach
            }
            result = Operator.calculateExpression(
                first = result,
                second = content.toInt(),
                operation = operator
            )
        }

        return result
    }
}
