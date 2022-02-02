package com.lcw.study.nextstep.domain

data class Expression(
    val rawExpression: String
) {
    operator fun plus(operand: Int): Expression {
        if (this == EMPTY) {
            return Expression(operand.toString())
        }
        val newRawExpression = if (rawExpression.last().toString().isOperator()) {
            rawExpression + operand

        } else {
            "$rawExpression$operand"
        }
        return Expression(newRawExpression)
    }

    operator fun plus(operator: String): Expression {
        if (this == EMPTY) return EMPTY
        return Expression("$rawExpression $operator ")
    }


    private fun String.isOperator(): Boolean = OPERATORS.contains(this)

    fun dropLast(): Expression {
        if (this == EMPTY) return EMPTY
        return Expression(rawExpression.dropLast(1).trim())
    }


    companion object {
        val EMPTY = Expression("")
        val OPERATORS = listOf("+", "-", "*", "/")
    }
}
