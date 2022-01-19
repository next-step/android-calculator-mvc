package net.woogear.domain

import net.woogear.domain.OperationType.Companion.getOperationType
import net.woogear.domain.OperationType.Companion.isOperator

class Calculator {
    private var answer = 0
    private var operationType: OperationType = OperationType.PLUS

    fun evaluate(s: String?): Int {
        if (s.isNullOrEmpty()) {
            throw IllegalArgumentException("Input Text Can't Be a Null or Empty")
        }

        calculate(s.split(" "))
        return answer
    }

    private fun calculate(splitTexts: List<String>) {
        for (text in splitTexts) {
            when {
                text.isOperator() -> operationType = getOperationType(text)
                text.isInt() -> answer = operationType.calculate(text.toInt(), answer)
                else -> throw IllegalArgumentException("$text is not supported type for input text")
            }
        }
    }

    private fun String.isOperator(): Boolean {
        return isOperator(this)
    }

    private fun String.isInt(): Boolean {
        return toIntOrNull() != null
    }
}