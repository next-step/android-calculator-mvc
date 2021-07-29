package edu.nextstep.camp.domain.stringcalculator

import java.util.*

/**
 * Created By Malibin
 * on 7월 29, 2021
 */

class CalculatorMemory(
    _expressionTokens: List<ExpressionToken> = emptyList()
) {
    constructor(vararg _expressionTokens: ExpressionToken) : this(_expressionTokens.toList())

    private val expressionTokens: MutableList<ExpressionToken> =
        arrangeExpressionTokens(_expressionTokens)

    private fun arrangeExpressionTokens(inputTokens: List<ExpressionToken>): MutableList<ExpressionToken> {
        if (inputTokens.isEmpty()) return mutableListOf()
        val inputQueue = LinkedList(inputTokens)
        val arrangedTokens = mutableListOf<ExpressionToken>(inputQueue.poll())
        while (inputQueue.isNotEmpty()) {
            var nextToken = inputQueue.poll()
            val previousToken = arrangedTokens.last()
            if (previousToken is Operand && nextToken is Operand) {
                arrangedTokens.removeLast()
                nextToken = previousToken.addLast(nextToken)
            }
            arrangedTokens.add(nextToken)
        }
        return arrangedTokens
    }

    fun putOperand(input: Operand): String {
        val lastInput = getLastInput()
        if (lastInput == null || lastInput is Operator) {
            expressionTokens.add(input)
        }
        if (lastInput is Operand) {
            expressionTokens.removeLast()
            expressionTokens.add(lastInput.addLast(input))
        }
        return getExpression()
    }

    fun putOperator(input: Operator): String {
        val lastInput = getLastInput() ?: return EMPTY_STRING
        if (lastInput is Operand) {
            expressionTokens.add(input)
        }
        if (lastInput is Operator) {
            expressionTokens.removeLast()
            expressionTokens.add(input)
        }
        return getExpression()
    }

    fun removeLast(): String {
        val lastInput = getLastInput() ?: return EMPTY_STRING
        if (lastInput is Operand) {
            expressionTokens.removeLast()
            expressionTokens.add(lastInput.removeLast())
        }
        if (lastInput is Operator) {
            expressionTokens.removeLast()
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
        private const val EMPTY_STRING = ""
    }
}
