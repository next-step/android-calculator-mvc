package com.example.calculator

class Expression(val rawExpression: String) {

    companion object {
        val EMPTY = Expression("")
    }

    operator fun plus(other: String): Expression {
        return Expression(rawExpression + other)
    }

    fun addOperator(operator: String): Expression {
        if (rawExpression.isEmpty()) return this
        if (isLastCharOperator()) return modifyOperator(operator)
        return this + operator
    }

    fun deleteExpression(): Expression {
        if (rawExpression.isEmpty()) return this
        return Expression(rawExpression.dropLast(1))
    }

    fun isValidate(): Boolean {
        if (rawExpression.isEmpty()) return false
        if (isLastCharOperator()) return false
        return true
    }

    private fun modifyOperator(operator: String): Expression {
        return deleteExpression() + operator
    }

    private fun isLastCharOperator() = !rawExpression.last().isDigit()
}