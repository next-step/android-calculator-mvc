package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluate(expression: String): Int {
        val expressionList = expression.split(" ")
        return calculate(expressionList)
    }

    private fun calculate(expressionList: List<String>): Int {
        var result = toOperand(expressionList[0])

        for (index in 1 until expressionList.size step 2) {
            result = Operator.find(expressionList[index])
                .calculate(result, toOperand(expressionList[index + 1]))
        }

        return result
    }

    private fun toOperand(expression: String): Int {
        return if (expression.isEmpty() || expression.toIntOrNull() == null) {
            throw IllegalArgumentException()
        } else {
            expression.toInt()
        }
    }
}