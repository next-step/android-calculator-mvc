package com.lcw.study.nextstep.domain

data class Expression(
    val rawExpression: String
) {
    private var operation: OperationType = OperationType.PLUS
    operator fun plus(operand: Int): Expression {
        if (this == EMPTY) {
            return Expression(operand.toString())
        }
        val newRawExpression = if (operation.checkTextIsOperationType(rawExpression.last().toString())) {
            rawExpression + operand

        } else {
            "$rawExpression$operand"
        }
        return Expression(newRawExpression)
    }

    operator fun plus(operator: String): Expression {
        if (this == EMPTY) return EMPTY
        return Expression("$rawExpression $operator")
    }

    fun dropLast(): Expression {
        if (this == EMPTY) return EMPTY
        return Expression(rawExpression.dropLast(1).trim())
    }


    companion object {
        val EMPTY = Expression("")
    }
}
