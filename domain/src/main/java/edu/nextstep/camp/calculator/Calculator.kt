package edu.nextstep.camp.calculator

class Calculator {

    fun evaluate(expression: String?): Int {
        val expressionStack = ExpressionStack()
        val expressionWithoutBlank = expression?.split(DELIMITER) ?: throw IllegalArgumentException()

        expressionWithoutBlank.forEach { str ->
            val stack = expressionStack.getStackForCalculating(str)
            stack?.let {
                val type = it.pop()
                val value = it.pop()
                val result = calculateValue(type, value.toInt(), str.toInt())
                expressionStack.pushResult(result.toString())
            }
        }
        return expressionStack.getStackPeekIntegerValue()
    }

    private fun calculateValue(type: String, value: Int, value2: Int) : Int {
        val result = when(type) {
            MathematicalSymbol.PLUS.type -> plus(value, value2)
            MathematicalSymbol.MINUS.type -> minus(value, value2)
            MathematicalSymbol.MULTIPLE.type -> multiple(value, value2)
            MathematicalSymbol.DIVIDE.type -> divide(value, value2)
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

    companion object {
        const val DELIMITER = " "
    }
}