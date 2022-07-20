package edu.nextstep.calculator.domain

class Editor {
    var expression: String = ""

    fun input(content: String) {
        if (ExpressionValidator.isNumber(content) &&
            ((expression.isEmpty()) || ExpressionValidator.isNumber(getExpressionLast()))
        ) {
            expression = expression.plus(content)
        } else if (ExpressionValidator.isOperator(content) &&
            ExpressionValidator.isNumber(getExpressionLast())
        ) {
            expression = expression.plus(" ").plus(content)
        }
    }

    fun erase() {}

    private fun getExpressionLast(): String? {
        if (expression.isEmpty() || expression.isBlank()) {
            return null
        }

        return expression.last().toString()
    }
}
