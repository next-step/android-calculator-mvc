package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluate(expression: Expression): Int {
        val expressionList = expression.expressionText.split(" ")
        return calculate(expressionList)
    }

    fun calculate(expressionList: List<String>): Int {
        var result = toOperand(expressionList[0])

        for (index in 1 until expressionList.size step 2) {
            result = Operator.find(expressionList[index])
                .calculate(result, toOperand(expressionList[index + 1]))
        }

        return result
    }

    fun toOperand(expression: String): Int {
        return if (expression.isEmpty() || expression.toIntOrNull() == null) {
            throw IllegalArgumentException()
        } else {
            expression.toInt()
        }
    }
}