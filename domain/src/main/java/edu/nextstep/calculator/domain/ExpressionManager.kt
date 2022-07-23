package edu.nextstep.calculator.domain

class ExpressionManager {
    private val expressionContents = mutableListOf<String>()

    fun input(content: String) {
        when {
            content.isOperator() -> {
                val operator: Operator = Operator.fromValue(content) ?: return
                inputOperator(operator)
            }
            content.isNumber() -> {
                inputNumber(content.toInt())
            }
        }
    }

    private fun inputNumber(number: Int) {
        if (expressionContents.lastOrNull().equals("0")) {
            expressionContents.removeLastOrNull()
        }

        val expressionItem = number.toString()

        when (expressionContents.lastOrNull().isNumber()) {
            true -> {
                val lastContent = expressionContents.lastOrNull()
                expressionContents.removeLastOrNull()
                expressionContents.add(lastContent.plus(expressionItem))
            }
            false -> {
                expressionContents.add(expressionItem)
            }
        }
    }

    private fun inputOperator(operator: Operator) {
        if (expressionContents.lastOrNull().isOperator()) {
            expressionContents.removeLastOrNull()
        }

        if (expressionContents.isEmpty().not()) {
            expressionContents.add(operator.value)
        }
    }

    fun getExpression(): String = expressionContents.joinToString(" ")

    fun isEnableCalculateExpression(): Boolean {
        return expressionContents.lastOrNull().isNumber()
    }

    fun erase() {
        when {
            expressionContents.lastOrNull().isNumber() -> {
                val lastContent = expressionContents.lastOrNull() ?: return
                expressionContents.removeLastOrNull()

                addExpressionContentIfNotEmptyContent(lastContent.dropLast(1))
            }
            expressionContents.lastOrNull().isOperator() -> {
                expressionContents.removeLastOrNull()
            }
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

    private fun String?.isOperator() = ExpressionValidator.isOperator(this)
    private fun String?.isNumber() = ExpressionValidator.isNumber(this)
}
