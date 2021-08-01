package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.operand.NumberOperand
import edu.nextstep.camp.calculator.domain.operand.Operand
import edu.nextstep.camp.calculator.domain.operand.Operator

class ExpressionHolder {
    private val expression = mutableListOf<Operand>()

    fun getCurrentExpression(): String {
        return expression.joinToString("")
    }

    fun addOperand(operand: Operand): String {
        when (operand) {
            is Operator -> addOperator(operand)
            is NumberOperand -> addNumberOperand(operand)
            else -> Unit
        }
        return getCurrentExpression()
    }

    fun deleteLast(): String {
        when (val last = expression.lastOrNull()) {
            is Operator -> expression.removeLast()
            is NumberOperand -> replaceLast(last.deleteLast())
            else -> Unit
        }
        return getCurrentExpression()
    }

    fun getResult(): Double {
        return Calculator.calculate(getCurrentExpression())
    }

    private fun addOperator(operator: Operator) {
        when (expression.lastOrNull()) {
            is Operator -> replaceLast(operator)
            is NumberOperand -> expression.add(operator)
            else -> Unit
        }
    }

    private fun addNumberOperand(operand: NumberOperand) {
        when (val last = expression.lastOrNull()) {
            is Operator, null -> expression.add(operand)
            is NumberOperand -> replaceLast(last.addNumberOperand(operand))
            else -> Unit
        }
    }

    private fun replaceLast(operand: Operand?) {
        expression.removeLast()
        operand?.let {
            expression.add(it)
        }
    }
}
