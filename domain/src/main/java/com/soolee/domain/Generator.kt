package com.soolee.domain

import com.soolee.domain.util.CalculatorInputUtil
import com.soolee.domain.validator.CalculatorInputValidator

class Generator {
    companion object {
        fun getCaculatorInputToTextArr(input: String): List<String> {
            checkIsInputEmpty(input)

            var textArr = input.split("").filter {
                it != " " && it != ""
            }

            checkIsTextArrValid(textArr)
            return textArr
        }

        private fun checkIsInputEmpty(input: String) {
            CalculatorInputValidator.isValueNotEmpty(input)
        }

        private fun checkIsTextArrValid(textArr: List<String>) {
            textArr.forEach { it ->
                if (!CalculatorInputUtil.isNumberRegex(it)) {
                    CalculatorInputValidator.isValidOperationMark(it)
                }
            }
        }
    }

}