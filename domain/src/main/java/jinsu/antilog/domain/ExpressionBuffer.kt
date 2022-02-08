package jinsu.antilog.domain

class ExpressionBuffer {
    private val expressionLetters = mutableListOf<ExpressionLetter>()


    fun addOperand(operand: Operand): String {
        when (val lastInput = getExpressionLastOrNull()) {
            is Operand -> expressionLetters.replaceLastTo(lastInput.addLastLetter(operand))
            is Operator, null -> expressionLetters.add(operand)
        }
        return getStringExpression()
    }

    fun addOperator(operator: Operator): String {
        when (getExpressionLastOrNull()) {
            is Operand -> expressionLetters.add(operator)
            is Operator -> expressionLetters.replaceLastTo(operator)
            null -> return EMPTY_STRING
        }
        return getStringExpression()
    }

    fun removeLast(): String {
        when (getExpressionLastOrNull()) {
            is Operand -> removeLastOperandLetter()
            is Operator -> expressionLetters.removeLast()
            null -> return EMPTY_STRING
        }
        return getStringExpression()
    }

    private fun removeLastOperandLetter() {
        val operand = expressionLetters.last() as Operand
        operand.removeLastLetter()
            ?.let { expressionLetters.replaceLastTo(it) }
            ?: expressionLetters.removeLast()
    }

    private fun MutableList<ExpressionLetter>.replaceLastTo(letter: ExpressionLetter) {
        this.removeLastOrNull() ?: return
        this.add(letter)
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