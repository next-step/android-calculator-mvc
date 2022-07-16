package com.soolee.domain.validator

class CalculatorInputValidator {
    fun isValidOperationMark(text: String): Boolean {
        var regex = Regex("[×÷+\\-]")
        return if (text.matches(regex)) {
            true
        } else {
            throw IllegalArgumentException("The Mark is not operation mark use: [× - + ÷]")
            false
        }
    }

    fun isValueNotEmpty(text: String): Boolean {
        return if (text != "" && text != null && text != " ") {
            true
        } else {
            throw IllegalArgumentException("string is empty or null")
            false
        }
    }
}