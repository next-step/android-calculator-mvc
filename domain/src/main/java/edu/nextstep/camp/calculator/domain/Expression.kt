package edu.nextstep.camp.calculator.domain


class Expression {
    var expressionText = ""

    fun add(operand: Int): String {
        if (Operator.isOperator(expressionText.lastOrNull().toString())) {
            expressionText += " "
        }
        expressionText += "$operand"
        return expressionText
    }

    fun add(operator: Operator): String {
        when {
            expressionText.isEmpty() -> expressionText
            Operator.isOperator(expressionText.lastOrNull().toString()) -> expressionText =
                expressionText.dropLast(1) + operator.operator
            else -> expressionText = expressionText + " " + operator.operator
        }
        return expressionText
    }

    fun add(operand: String?) {
        when {
            operand.isNullOrEmpty() -> throw IllegalArgumentException()
            operand.isNumber() -> add(operand.toInt())
            Operator.isOperator(operand) -> Operator.find(operand)
            else -> throw IllegalArgumentException()
        }
    }

    fun remove(): String {
        if (expressionText.isEmpty()) {
            return expressionText
        }
        expressionText = expressionText.substring(0, expressionText.length - getDeleteSize())
        return expressionText
    }

    private fun getDeleteSize(): Int {
        return if (expressionText.lastIndex > 0 && expressionText[expressionText.lastIndex - 1] == ' ') {
            INCLUDE_SPACES_DELETE_SIZE
        } else {
            DEFAULT_DELETE_SIZE
        }
    }

    fun isCompletedExpression(): Boolean {
        if (expressionText.last().toString().isNumber().not()) {
            return false
        }
        return true
    }

    companion object {
        private const val DEFAULT_DELETE_SIZE = 1
        private const val INCLUDE_SPACES_DELETE_SIZE = 2
    }
}

fun String.isNumber(): Boolean {
    return try {
        this.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}