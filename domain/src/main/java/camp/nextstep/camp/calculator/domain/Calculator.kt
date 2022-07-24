package camp.nextstep.camp.calculator.domain

import camp.nextstep.camp.calculator.domain.Calculator.Operators.*


object Calculator {

    private val rewExpressionCheck = RawExpressionCheck()
    private const val delimiter = " "

    fun evaluate(expression: String): Int {
        rewExpressionCheck.isNullOrBlankCheck(expression)

        val expressionSplitList: List<String> = expression.split(delimiter)

        rewExpressionCheck.isNumericCheck(expressionSplitList[0])
        var result = expressionSplitList[0].toInt()

        for (index in 1 until expressionSplitList.size step 2) {
            rewExpressionCheck.isNumericCheck(expressionSplitList[index + 1])
            result = calculate(
                result,
                expressionSplitList[index],
                expressionSplitList[index + 1].toInt()
            )
        }

        return result
    }

    private fun calculate(operandFirst: Int, operator: String, operandSecond: Int): Int {
        return when (operator) {
            Plus.operator -> plus(operandFirst, operandSecond)
            Minus.operator -> minus(operandFirst, operandSecond)
            Multiply.operator -> multiply(operandFirst, operandSecond)
            Divide.operator -> divide(operandFirst, operandSecond)
            else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }
    }

    private fun plus(operandFirst: Int, operandSecond: Int) =
        operandFirst + operandSecond

    private fun minus(operandFirst: Int, operandSecond: Int) =
        operandFirst - operandSecond

    private fun multiply(operandFirst: Int, operandSecond: Int) =
        operandFirst * operandSecond

    private fun divide(operandFirst: Int, operandSecond: Int) =
        operandFirst / operandSecond

    enum class Operators(val operator: String) {
        Plus("+"),
        Minus("-"),
        Multiply("*"),
        Divide("/")
    }
}