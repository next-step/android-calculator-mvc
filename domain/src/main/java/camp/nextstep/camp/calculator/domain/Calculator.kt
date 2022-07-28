package camp.nextstep.camp.calculator.domain

import camp.nextstep.camp.calculator.domain.Calculator.Operator.*


object Calculator {

    private val rewExpressionCheck = RawExpressionCheck()
    private const val delimiter = " "

    fun evaluate(expression: String): Int {
        rewExpressionCheck.checkNullOrBlank(expression)

        val expressionSplitList: List<String> = expression.split(delimiter)

        rewExpressionCheck.checkNumber(expressionSplitList[0])
        var result = expressionSplitList[0].toInt()

        for (index in 1 until expressionSplitList.size step 2) {
            rewExpressionCheck.checkNumber(expressionSplitList[index + 1])
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
            Plus.value -> Plus.operate(operandFirst, operandSecond)
            Minus.value -> Minus.operate(operandFirst, operandSecond)
            Multiply.value -> Multiply.operate(operandFirst, operandSecond)
            Divide.value -> Divide.operate(operandFirst, operandSecond)
            else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }
    }

    enum class Operator(val value: String) {
        Plus("+") {
            override fun operate(operandFirst: Int, operandSecond: Int): Int =
                operandFirst + operandSecond
        },
        Minus("-") {
            override fun operate(operandFirst: Int, operandSecond: Int): Int =
                operandFirst - operandSecond
        },
        Multiply("*") {
            override fun operate(operandFirst: Int, operandSecond: Int): Int =
                operandFirst * operandSecond
        },
        Divide("/") {
            override fun operate(operandFirst: Int, operandSecond: Int): Int =
                operandFirst / operandSecond
        };

        abstract fun operate(operandFirst: Int, operandSecond: Int): Int
    }
}