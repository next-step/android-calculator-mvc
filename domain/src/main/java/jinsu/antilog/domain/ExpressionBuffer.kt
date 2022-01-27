package jinsu.antilog.domain

import java.util.LinkedList

class ExpressionBuffer {
    private val expressionLetters = LinkedList<ExpressionLetter>()


    fun addOperand(operand: Operand): String {
        when (getExpressionLastOrNull()) {
            is Operand -> {(expressionLetters.last as Operand).addLastLetter(operand)}
            is Operator, null -> expressionLetters.add(operand)
        }
        return getStringExpression()
    }

    fun addOperator(operator: Operator): String {
        when (getExpressionLastOrNull() ?: return EMPTY_STRING) {
            is Operand -> expressionLetters.add(operator)
            is Operator -> expressionLetters.replaceLastTo(operator)
        }
        return getStringExpression()
    }

    fun removeLast(): String {
        when (getExpressionLastOrNull() ?: return EMPTY_STRING) {
            is Operand -> {
                (expressionLetters.last as Operand).removeLastLetter()
                    ?:expressionLetters.removeLast()
            }
            is Operator -> expressionLetters.removeLast()
        }
        return getStringExpression()
    }

    private fun LinkedList<ExpressionLetter>.replaceLastTo(operator: Operator) {
        this.removeLastOrNull() ?: return
        this.add(operator)
    }

    private fun getExpressionLastOrNull(): ExpressionLetter? {
        return expressionLetters.lastOrNull()
    }

    fun getStringExpression(): String {
        return expressionLetters.joinToString(DELIMITER)
    }

    companion object {
        private const val EMPTY_STRING = ""
        private const val DELIMITER = " "
    }
}