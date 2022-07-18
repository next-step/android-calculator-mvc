package edu.nextstep.calculator.domain

object Calculator {
    private fun splitExpression(expression: String): List<String> {
        ExpressionValidation.isValidExpression(expression)
        return expression.split(" ")
    }

    fun calculate(expression: String?): Int {
        require(!expression.isNullOrBlank()) {
            "입력값이 null이거나 빈 공백 문자입니다."
        }

        val expressionContents = splitExpression(expression)

        var result = expressionContents.first().toInt()
        var operator = Operator.UNDEFINED
        expressionContents.forEach { content ->
            Operator.fromValue(content)?.let {
                operator = it
                return@forEach
            }
            result = operator.calculate(
                first = result,
                second = content.toInt(),
            )
        }

        return result
    }
}
