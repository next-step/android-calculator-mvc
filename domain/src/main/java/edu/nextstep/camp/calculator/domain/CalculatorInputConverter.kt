package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.validator.CalculatorInputValidator

object CalculatorInputConverter {
    fun getCalculatorInputToTextArr(input: String): List<String> {
        CalculatorInputValidator.checkIsInputEmpty(input)

        var textArr = input.split("").filter {
            it != " " && it != ""
        }

        CalculatorInputValidator.checkIsArrContainValidOperator(textArr)
        return textArr
    }
}