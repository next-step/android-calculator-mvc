package edu.nextstep.camp.calculator.domain

import java.math.BigDecimal

class Calculator(
    private val blankSplitter: BlankSplitter,
    private val validator: Validator
) {

    fun evaluate(inputCalculatorContents: String?): BigDecimal {
        if (inputCalculatorContents.isNullOrBlank()) {
            throw IllegalArgumentException("null 혹은 빈 값은 들어올 수 없습니다.")
        }

        return calculate(blankSplitter.removeBlankCalculatorContent(inputCalculatorContents))
    }

    private fun calculate(calculatorContent: List<String>): BigDecimal {
        var result = BigDecimal(calculatorContent.first())

        return calculatorContent.forEachIndexed { index, inputString ->
            if (validator.isOperator(inputString)) {
                val operator = Operator.find(inputString)
                val calculateValue = operator?.calculate?.invoke(result, BigDecimal(calculatorContent[index + 1]))
                calculateValue?.also { result = calculateValue }
            } else {
                validator.isNumeric(inputString)
            }
        }.run {
            result
        }
    }

}