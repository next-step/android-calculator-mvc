package edu.nextstep.calculator.domain

class Editor {
    var expression: String = ""

    fun input(content: String) {
        if (ExpressionValidator.isNumber(content) &&
            (expression.isEmpty()) || ExpressionValidator.isNumber(expression.last().toString())
        ) {
            expression = expression.plus(content)
        }
    }
}
