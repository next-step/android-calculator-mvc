package edu.nextstep.camp.calculator.domain

class ExpressionBuilder {

    private val expressionValue = mutableListOf<String>()

    fun addOperand(token: String) {
        when (lastTokenType()) {
            TokenType.Operand -> {
                expressionValue[expressionValue.lastIndex] = "${expressionValue.last()}${token}"
            }
            TokenType.Operator, null -> {
                expressionValue.add(token)
            }
        }
    }

    fun addOperator(token: String) {
        when (lastTokenType()) {
            TokenType.Operand -> {
                expressionValue.add(token)
            }
            TokenType.Operator -> {
                expressionValue[expressionValue.lastIndex] = token
            }
            null -> {
                return
            }
        }
    }

    fun removeLastToken() {
        expressionValue.removeLastOrNull()
    }

    fun getUiExpressionText() = expressionValue.joinToString(" ")

    fun getValidExpressionText(): String {
        when (lastTokenType()) {
            null, TokenType.Operator -> throw IllegalArgumentException("완성되지 않은 수식입니다")
            else -> return expressionValue.joinToString(" ") { toValidToken(it) }
        }
    }

    fun clear() {
        expressionValue.clear()
    }

    private fun toValidToken(token: String): String {
        return when (token) {
            "×" -> "*"
            "÷" -> "/"
            else -> token
        }
    }

    private fun lastTokenType(): TokenType? {
        val last = expressionValue.lastOrNull() ?: return null

        val number = last.toIntOrNull()
        return if (number == null) {
            TokenType.Operator
        } else {
            TokenType.Operand
        }
    }
}