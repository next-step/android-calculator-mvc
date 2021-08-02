package edu.nextstep.camp.domain.stringcalculator

import app.cash.exhaustive.Exhaustive
import java.util.*

/**
 * Created By Malibin
 * on 7월 29, 2021
 */

class CalculatorMemory(
    expressionTokens: List<ExpressionToken> = emptyList()
) {
    constructor(vararg expressionTokens: ExpressionToken) : this(expressionTokens.toList())

    private val expressionTokens: MutableList<ExpressionToken> =
        arrangeExpressionTokens(expressionTokens)

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
        @Exhaustive
        when (val lastInput = getLastInput()) {
            is Operator, null -> expressionTokens.add(input)
            is Operand -> expressionTokens.replaceLastWith(lastInput.addLast(input))
        }
        return getExpression()
    }

    fun putOperator(input: Operator): String {
        @Exhaustive
        when (getLastInput() ?: return EMPTY_STRING) {
            is Operator -> expressionTokens.replaceLastWith(input)
            is Operand -> expressionTokens.add(input)
        }
        return getExpression()
    }

    fun removeLast(): String {
        @Exhaustive
        when (val lastInput = getLastInput() ?: return EMPTY_STRING) {
            is Operator -> expressionTokens.removeLast()
            is Operand -> expressionTokens.replaceLastWith(lastInput.removeLast())
        }
        return getExpression()
    }

    fun getExpression(): String {
        return expressionTokens.joinToString(DELIMITER)
    }

    private fun getLastInput(): ExpressionToken? {
        return expressionTokens.lastOrNull()
    }

    private fun MutableList<ExpressionToken>.replaceLastWith(token: ExpressionToken?) {
        if (this.isEmpty()) return
        this.removeLast()
        this.add(token ?: return)
    }

    companion object {
        private const val DELIMITER = " "
        private const val EMPTY_STRING = ""
    }
}
