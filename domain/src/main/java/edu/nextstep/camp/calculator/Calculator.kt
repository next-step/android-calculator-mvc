package edu.nextstep.camp.calculator

import java.util.*

class Calculator {

    fun evaluate2(stack: Stack<String>): Int {
        if (stack.size == 1) return stack.pop().toInt()
        val value = stack.pop().toInt()
        val type = stack.pop()
        val value2 = stack.pop().toInt()
        val result = calculateValue(type, value, value2)
        stack.push(result.toString())
        return evaluate2(stack)
    }

    fun evaluate(expression: Expression): Int {
        if (expression.isReadyForCalculating().not()) {
            return expression.getCurrentValue()
        }

        val operand1 = expression.getOperand()
        val operator = expression.getOperator()
        val operand2 = expression.getOperand()
        val result = calculateValue(operator, operand1, operand2)

        expression.pushResult(result)

        return evaluate(expression)
    }

    private fun calculateValue(operator: String, operand1: Int, operand2: Int) : Int {
        val result = when(operator) {
            MathematicalSymbol.PLUS.type -> plus(operand1, operand2)
            MathematicalSymbol.MINUS.type -> minus(operand1, operand2)
            MathematicalSymbol.MULTIPLE.type -> multiple(operand1, operand2)
            MathematicalSymbol.DIVIDE.type -> divide(operand1, operand2)
            else -> throw IllegalArgumentException()
        }
        return result
    }

    private fun plus (value: Int, value2: Int) : Int {
        return value + value2
    }

    private fun multiple (value: Int, value2: Int) : Int {
        return value * value2
    }

    private fun divide (value: Int, value2: Int) : Int {
        return value / value2
    }

    private fun minus (value: Int, value2: Int) : Int {
        return value - value2
    }
}