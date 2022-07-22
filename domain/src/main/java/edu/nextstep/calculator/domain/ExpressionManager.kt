package edu.nextstep.calculator.domain

class ExpressionManager {
    private val expressionContents = mutableListOf<String>()

    fun input(content: String) {
        if (ExpressionValidator.isOperator(content)) {
            val operator: Operator = Operator.fromValue(content) ?: return
            input(operator)
            return
        } else if (content == DELETE) {
            erase()
            return
        }

        if (expressionContents.lastOrNull().equals("0") && ExpressionValidator.isNumber(content)) {
            expressionContents.removeLastOrNull()
        }

        if (ExpressionValidator.isNumber(content) && ExpressionValidator.isNumber(expressionContents.lastOrNull()).not()) {
            expressionContents.add(content)
        } else if (ExpressionValidator.isNumber(content) && ExpressionValidator.isNumber(expressionContents.lastOrNull())) {
            val lastContent = expressionContents.lastOrNull()
            expressionContents.removeLastOrNull()
            expressionContents.add(lastContent.plus(content))
        }
    }

    fun input(operator: Operator) {
        if (ExpressionValidator.isOperator(expressionContents.lastOrNull())) {
            expressionContents.removeLastOrNull()
        }

        if (expressionContents.isEmpty().not()) {
            expressionContents.add(operator.value)
        }
    }

    fun getExpression(): String = expressionContents.joinToString(" ")

    fun isEnableCalculateExpression(): Boolean {
        return ExpressionValidator.isNumber(expressionContents.lastOrNull())
    }

    private fun erase() {
        if (ExpressionValidator.isNumber(expressionContents.lastOrNull())) {
            val lastContent = expressionContents.lastOrNull() ?: return
            expressionContents.removeLastOrNull()

            addExpressionContentIfNotEmptyContent(lastContent.dropLast(1))
        } else if (ExpressionValidator.isOperator(expressionContents.lastOrNull())) {
            expressionContents.removeLastOrNull()
        }
    }

    fun resetExpression(content: String?) {
        expressionContents.clear()
        content?.let {
            ExpressionValidator.isValidExpression(content)
            expressionContents.add(it)
        }
    }

    private fun addExpressionContentIfNotEmptyContent(lastContent: String) {
        if (lastContent.isEmpty().not()) {
            expressionContents.add(lastContent)
        }
    }

    companion object {
        const val DELETE = "DELETE"
    }
}
