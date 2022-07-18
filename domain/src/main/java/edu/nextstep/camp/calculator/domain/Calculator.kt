package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluatesExpression(expression: String?): Double {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자")

        val inputList = splitExpression(expression)

        return calculate(inputList)
    }

    private fun calculate(inputList: List<String>): Double {
        var result = inputList[0].toDouble()
        for (i in 1 until inputList.size step (CALCULATION_SIZE)) {
            val operator = inputList[i]
            val operand = inputList[i + 1].toDouble()

            result = Operator.get(operator).calculate(result, operand)
        }
        return result
    }

    private fun splitExpression(expression: String) = expression.split(" ")

    companion object {
        private const val CALCULATION_SIZE = 2

    }

}