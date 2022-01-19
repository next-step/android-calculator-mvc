package net.woogear.domain

import net.woogear.domain.OperationType.Companion.getOperationType
import net.woogear.domain.OperationType.Companion.isOperationType

class Calculator {
    private var answer = 0
    private var operationType: OperationType = OperationType.PLUS

    fun evaluate(s: String?): Int {
        if (s.isNullOrEmpty()) {
            throw IllegalArgumentException("Input Text Can't Be a Null or Empty")
        }

        splitAndCheck(s)
        return answer
    }

    private fun splitAndCheck(input: String) {
        val splitTexts: List<String> = input.split(" ")

        for (text in splitTexts) {
            if (isOperationType(text)) {
                operationType = getOperationType(text)
                continue
            }

            if (text.isInt()) {
                answer = operationType.calculate(text.toInt(), answer)
                continue
            }

            throw IllegalArgumentException("$text is not supported type for input text")
        }
    }

    private fun String.isInt(): Boolean {
        return when(toIntOrNull()) {
            null -> false
            else -> true
        }
    }
}