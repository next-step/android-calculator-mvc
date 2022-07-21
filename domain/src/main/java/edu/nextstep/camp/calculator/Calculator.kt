package edu.nextstep.camp.calculator

class Calculator {

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