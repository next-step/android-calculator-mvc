package edu.nextstep.camp.domain.stringcalculator

/**
 * Created By Malibin
 * on 7월 29, 2021
 */

class CalculatorMemory(
    private val expressionTokens: MutableList<ExpressionToken> = mutableListOf()
) {

    fun putOperand(input: Operand): String {
        val lastInput = getLastInput()
        if (lastInput == null) {
            expressionTokens.add(input)
        }
        if(lastInput is Operand){
            expressionTokens.removeLast()
//            expressionTokens.add(current)
        }
        return getExpression()
    }

    fun getExpression(): String {
        return expressionTokens.joinToString(DELIMITER)
    }

    private fun getLastInput(): ExpressionToken? {
        return expressionTokens.lastOrNull()
    }

    companion object {
        private const val DELIMITER = " "
    }
}
