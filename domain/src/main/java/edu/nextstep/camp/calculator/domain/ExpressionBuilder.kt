package edu.nextstep.camp.calculator.domain

class ExpressionBuilder {

    private val expressionValue = mutableListOf<Node>()

    fun addOperand(operand: Operand) {
        when (val lastNode = expressionValue.lastOrNull()) {
            is Operator, null -> expressionValue.add(operand)
            is Operand -> {
                val number = ("${lastNode.value}${operand.value}").toInt()
                expressionValue[expressionValue.lastIndex] = Operand(number)
            }
        }
    }

    fun addOperator(operator: Operator) {
        when (expressionValue.lastOrNull()) {
            is Operand -> expressionValue.add(operator)
            is Operator -> expressionValue[expressionValue.lastIndex] = operator
            null -> return
        }
    }

    fun removeLastToken() {
        expressionValue.removeLastOrNull()
    }

    fun build(): String = expressionValue.map {
        when (it) {
            is Operand -> it.value
            is Operator -> it.symbol
        }
    }.joinToString(" ")

    fun clear() {
        expressionValue.clear()
    }
}