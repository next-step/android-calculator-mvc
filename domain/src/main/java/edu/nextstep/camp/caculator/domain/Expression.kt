package edu.nextstep.camp.caculator.domain

import java.lang.StringBuilder
import java.util.*

class Expression {
    private var expressionString: StringBuilder = StringBuilder()

    fun getExpressionString(): String = expressionString.toString()

    fun toExpressionData(): ExpressionData {
        val queue: Queue<String> = LinkedList()
        queue.addAll(expressionString.split(EXPRESSION_SEPARATOR))

        return generateExpressionData(queue)
    }

    fun addExpression(expression: String) {
        require(expression.isNotEmpty()
                && (isInteger(expression)
                || AVAILABLE_INPUT_OPERATORS.contains(expression)))
        {"Expression is empty or wrong expression"}

        when {
            isInteger(expression) -> addValueExpression(expression)
            AVAILABLE_INPUT_OPERATORS.contains(expression) -> addValueOperator(expression)
        }
    }

    fun isValidExpression(): Boolean = AVAILABLE_INPUT_OPERATORS.contains(expressionString.last()).not()

    fun clear() {
        expressionString.clear()
    }

    fun deleteLastExpression() {
        with(this.expressionString) {
            when {
                isEmpty() -> return
                length < 2 -> clear()
                get(length-2) == EXPRESSION_SEPARATOR -> deleteRange(length-2, length)
                else -> deleteRange(length-1, length)
            }   
        }
    }

    private fun isInteger(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun addValueExpression(expression: String) {
        with(this.expressionString) {
            if (isNotEmpty() && AVAILABLE_INPUT_OPERATORS.contains(last())) append(EXPRESSION_SEPARATOR)

            append(expression)
        }
    }

    private fun addValueOperator(expression: String) {
        with(this.expressionString) {
            when {
                isEmpty() -> return
                AVAILABLE_INPUT_OPERATORS.contains(last()) -> deleteCharAt(length-1)
            }

            append(EXPRESSION_SEPARATOR).append(expression)
        }
    }

    private fun generateExpressionData(stack: Queue<String>): ExpressionData {
        val essence = stack.poll()?.let { ExpressionData.Essence(it.toInt()) }?:ExpressionData.NaN

        return if (stack.isEmpty()) {
            essence
        } else {
            when (stack.poll()) {
                "+" -> ExpressionData.Sum(essence, generateExpressionData(stack))
                "-" -> ExpressionData.Subtract(essence, generateExpressionData(stack))
                "/" -> ExpressionData.Divide(essence, generateExpressionData(stack))
                "*" -> ExpressionData.Multiply(essence, generateExpressionData(stack))
                else -> {ExpressionData.NaN}
            }
        }
    }

    companion object {
        const val AVAILABLE_INPUT_OPERATORS = "+-/*"
        const val EXPRESSION_SEPARATOR = ' '
    }
}