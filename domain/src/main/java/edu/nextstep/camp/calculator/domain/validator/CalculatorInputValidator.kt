package edu.nextstep.camp.calculator.domain.validator

import edu.nextstep.camp.calculator.domain.util.CalculatorInputUtil

class CalculatorInputValidator {
    companion object {
        fun isValidOperationMark(text: String): Boolean {
            return if (CalculatorInputUtil.isOperationMarkRegex(text)) {
                true
            } else {
                throw IllegalArgumentException("The Mark is not operation mark use: [× - + ÷]")
            }
        }

        private fun isValidOperationNumber(text: String): Boolean {
            return if (CalculatorInputUtil.isNumberRegex(text)) {
                true
            } else {
                throw IllegalArgumentException("The Number is not calculatable use: [0-9]")
            }
        }

        fun checkIsInputEmpty(text: String) {
            if (text.isEmpty() || text == " ") {
                throw IllegalArgumentException("string is empty or null")
            }
        }

        fun checkIsArrContainValidOperator(textArr: List<String>): Boolean {
            var ok = true
            textArr.forEach { it ->
                ok = if (!CalculatorInputUtil.isNumberRegex(it)) {
                    isValidOperationMark(it)
                } else {
                    isValidOperationNumber(it)
                }
            }
            return ok
        }
    }
}