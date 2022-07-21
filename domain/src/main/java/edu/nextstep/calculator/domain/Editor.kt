package edu.nextstep.calculator.domain

class Editor {
    private val expressionContents = mutableListOf<String>()

    fun input(content: String) {
        if (ExpressionValidator.isNumber(content) && ExpressionValidator.isNumber(getExpressionLast()).not()) {
            expressionContents.add(content)
        } else if (ExpressionValidator.isNumber(content) && ExpressionValidator.isNumber(getExpressionLast())) {
            val lastContent = expressionContents.last()
            expressionContents.removeLast()
            expressionContents.add(lastContent.plus(content))
        }
    }

    fun input(operator: Operator) {
        if (ExpressionValidator.isOperator(getExpressionLast())) {
            expressionContents.removeLast()
        }

        if (expressionContents.isEmpty().not()) {
            expressionContents.add(operator.value)
        }
    }

    fun getExpression(): String {
        var expression = ""
        expressionContents.forEach {
            expression = expression.plus("$it ")
        }

        // 마지막 공백 제거한 뒤 return
        return expression.dropLast(1)
    }

    fun isEnableCalculateExpression(): Boolean {
        return ExpressionValidator.isNumber(getExpressionLast())
    }

    fun erase() {
        if (ExpressionValidator.isNumber(getExpressionLast())) {
            val lastContent = expressionContents.last()
            expressionContents.removeLast()

            addExpressionContentIfNotEmptyContent(lastContent.dropLast(1))
        } else if (ExpressionValidator.isOperator(getExpressionLast())){
            expressionContents.removeLast()
        }
    }

    private fun addExpressionContentIfNotEmptyContent(lastContent: String) {
        if (lastContent.isEmpty().not()) {
            expressionContents.add(lastContent)
        }
    }

    private fun getExpressionLast(): String? {
        if (expressionContents.isEmpty()) return null
        return expressionContents.last()
    }
}
