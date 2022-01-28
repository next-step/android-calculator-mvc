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
            Expression(rawExpression.dropLast(DROP_LAST_OPERATOR))
        }
    }

    private fun removeLastDigit(): Expression {
        return when {
            rawExpression.length == 1 -> {
                Expression(rawExpression.dropLast(DROP_LAST_OPERAND))
            }
            rawExpression.dropLast(DROP_LAST_OPERAND).last().toString() == " " -> {
                Expression(rawExpression.dropLast(OPERAND_MIX_OPERATOR))
            }
            else -> {
                Expression(rawExpression.dropLast(DROP_LAST_OPERAND))
            }
        }
    }

    fun getResult(): Float {
        return Calculator.evaluate(rawExpression)
    }

    companion object {
        val EMPTY = Expression("")

        const val DROP_LAST_OPERAND = 1
        const val DROP_LAST_OPERATOR = 2
        const val OPERAND_MIX_OPERATOR = 2
    }
}