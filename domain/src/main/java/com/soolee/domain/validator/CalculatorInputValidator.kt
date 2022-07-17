package com.soolee.domain.validator

import com.soolee.domain.util.CalculatorInputUtil

class CalculatorInputValidator {
    companion object {
        fun isValidOperationMark(text: String): Boolean {
            return if (CalculatorInputUtil.isOperationMarkRegex(text)) {
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
}