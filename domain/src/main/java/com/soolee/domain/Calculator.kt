package com.soolee.domain

import com.soolee.domain.validator.CalculatorInputValidator
import com.soolee.domain.util.CalculatorInputUtil

class Calculator {
    var inputValidator = CalculatorInputValidator()
    var inputUtil = CalculatorInputUtil()

    fun calculate(text: String): Int {
        var isStringNotEmpty = inputValidator.isValueNotEmpty(text)
        if (!isStringNotEmpty) {
            return 0
        }

        var textArr = text.split("").filter {
            it != " " && it != ""
        }

        println(textArr)
        var accumulated = 0
        var operation = "undefined"

        textArr.forEach { text ->
            var isNumber = inputUtil.checkIsNumberTypeString(text);
            if (isNumber) {
                accumulated = operator(accumulated, text, operation)
            } else {
                var isValidOperationMark = inputValidator.isValidOperationMark(text)
                if (isValidOperationMark) {
                    operation = text
                }
                return@forEach
            }
        }
        return accumulated
    }

    private fun operator(accumulated: Int, next: String, operation: String): Int {
        val nextInt = next.toInt()
        return when (operation) {
            "+" -> plus(accumulated, nextInt)
            "-" -> minus(accumulated, nextInt)
            "×" -> multiply(accumulated, nextInt)
            "÷" -> divide(accumulated, nextInt)
            else -> addString(accumulated, nextInt)
        }
    }

    private fun plus(accumulated: Int, next: Int): Int = accumulated + next
    private fun minus(accumulated: Int, next: Int): Int = accumulated - next
    private fun multiply(accumulated: Int, next: Int): Int = accumulated * next
    private fun divide(accumulated: Int, next: Int): Int = accumulated / next
    private fun addString(accumulated: Int, next: Int): Int =
        (accumulated.toString() + next.toString()).toInt()
}
