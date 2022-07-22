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

        val isNumberByContent: Boolean = ExpressionValidator.isNumber(content)
        val isNumberByExpressionContentLast: Boolean = ExpressionValidator.isNumber(expressionContents.lastOrNull())

        if (expressionContents.lastOrNull().equals("0") && isNumberByContent) {
            expressionContents.removeLastOrNull()
        }

        if (isNumberByContent && isNumberByExpressionContentLast.not()) {
            expressionContents.add(content)
        } else if (isNumberByContent && isNumberByExpressionContentLast) {
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
