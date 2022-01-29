package com.example.calculator

import java.lang.IllegalArgumentException

class Calculator {
    private val expressionCheckRegex = "^([0-9]+[-×÷+])+[0-9]+".toRegex()
    private val operandSplitRegex = "[-×÷+]".toRegex()

    fun evaluate(inputString: String?): Int {
        val expression = isValidate(inputString)
        val operandList = expression.split(operandSplitRegex)
        val operatorList = expression.filter { !it.isDigit() }

        var result = operandList[0].toInt()

        for (index in 1..operandList.lastIndex) {
            val currentOperator = Operator.get(operatorList[index - 1])
            result = compute(result, operandList[index], currentOperator)
        }

        return result
    }

    private fun compute(firstOperand: Int, secondOperand: String, currentOperator: Operator): Int {
        var result = firstOperand
        result = currentOperator.calculate(result, secondOperand.toInt())
        return result
    }

    private fun isValidate(inputString: String?): String {
        require(inputString.isNullOrEmpty() || expressionCheckRegex.matches(inputString)) {
            IllegalArgumentException()
        }
        return inputString?.trim() ?: throw IllegalArgumentException()
    }
}