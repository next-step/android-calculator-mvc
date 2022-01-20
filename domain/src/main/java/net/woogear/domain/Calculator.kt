package net.woogear.domain

import net.woogear.domain.OperationType.Companion.getOperationType
import net.woogear.domain.OperationType.Companion.isOperator

class Calculator {

    fun evaluate(s: String?): Int {
        if (s.isNullOrEmpty()) {
            throw IllegalArgumentException("Input Text Can't Be a Null or Empty")
        }

        return calculate(s.split(" "))
    }

    private fun calculate(splitTexts: List<String>): Int {
        var answer = 0
        var operationType: OperationType = OperationType.PLUS

        for (text in splitTexts) {
            when {
                text.isOperator() -> operationType = getOperationType(text)
                text.isInt() -> answer = operationType.calculate(text.toInt(), answer)
                else -> throw IllegalArgumentException("$text is not supported type for input text")
            }
        }

        return answer
    }

    private fun String.isOperator(): Boolean {
        return isOperator(this)
    }

    private fun String.isInt(): Boolean {
        return toIntOrNull() != null
    }
}