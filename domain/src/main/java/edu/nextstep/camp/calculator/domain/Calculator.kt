package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluate(expression: String): Int {
        val expressionList = expression.split(" ")
        var result = toInt(expressionList[0])

        for (index in 1 until expressionList.size step 2) {
            result = Operator.get(expressionList[index])
                .calculate(result, toInt(expressionList[index + 1]))
        }

        return result
    }

    private fun toInt(expression: String): Int {
        return if (expression.isEmpty() || expression.toIntOrNull() == null) {
            throw IllegalArgumentException()
        } else {
            expression.toInt()
        }
    }
}