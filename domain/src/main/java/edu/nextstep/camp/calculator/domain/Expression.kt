package edu.nextstep.camp.calculator.domain

data class Expression(val rawExpression: String) {
    fun addOperand(operand: String): Expression {
        if (this == EMPTY) return Expression(operand)
        return if (rawExpression.last().isDigit()) {
            Expression("$rawExpression$operand")
        } else {
            Expression("$rawExpression $operand")
        }
    }

    fun addOperator(operator: String): Expression {
        if (this == EMPTY) return EMPTY
        return if (rawExpression.last().isDigit()) {
            Expression("$rawExpression $operator")
        } else {
            Expression("${rawExpression.dropLast(1)}$operator")
        }
    }

    fun removeLast(): Expression {
        if (this == EMPTY) return EMPTY
        return if (rawExpression.last().isDigit()) {
            removeLastDigit()
        } else {
            Expression(rawExpression.dropLast(2))
        }
    }

    private fun removeLastDigit(): Expression {
        return when {
            rawExpression.length == 1 -> {
                Expression(rawExpression.dropLast(1))
            }
            rawExpression.dropLast(1).last().toString() == " " -> {
                Expression(rawExpression.dropLast(2))
            }
            else -> {
                Expression(rawExpression.dropLast(1))
            }
        }
    }

    fun getResult(): Float {
        return Calculator.evaluate(rawExpression)
    }

    companion object {
        val EMPTY = Expression("")
    }
}