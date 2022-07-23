package edu.nextstep.calculator.domain

class ExpressionManager {
    private val expressionContents = mutableListOf<String>()

    fun input(content: String) {
        when {
            ExpressionValidator.isOperator(content) -> {
                val operator: Operator = Operator.fromValue(content) ?: return
                inputOperator(operator)
            }
            ExpressionValidator.isNumber(content) -> {
                inputNumber(content.toInt())
            }
        }
    }

    private fun inputNumber(number: Int) {
        if (expressionContents.lastOrNull().equals("0")) {
            expressionContents.removeLastOrNull()
        }

        val expressionItem = number.toString()
        val isNumberByExpressionContentLast: Boolean = ExpressionValidator.isNumber(expressionContents.lastOrNull())

        if (isNumberByExpressionContentLast.not()) {
            expressionContents.add(expressionItem)
        } else if (isNumberByExpressionContentLast) {
            val lastContent = expressionContents.lastOrNull()
            expressionContents.removeLastOrNull()
            expressionContents.add(lastContent.plus(expressionItem))
        }
    }

    private fun inputOperator(operator: Operator) {
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

    fun erase() {
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
}
