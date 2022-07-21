package edu.nextstep.camp.calculator.domain

import java.math.BigDecimal

class Calculator(
    private val blankSplitter: BlankSplitter = BlankSplitter(),
    private val validator: Validator = Validator()
) {

    fun evaluate(inputCalculatorContents: String): BigDecimal {
        require(inputCalculatorContents.isNotBlank()) { IllegalArgumentException("공백이나 null은 들어올 수 없습니다.") }

        return calculate(blankSplitter.removeBlankCalculatorContent(inputCalculatorContents))
    }

    private fun calculate(calculatorContent: List<String>): BigDecimal {
        var result = BigDecimal(calculatorContent.first())

        return calculatorContent.forEachIndexed { index, inputString ->
            if (validator.isOperator(inputString)) {
                val operator = Operator.find(inputString)
                val calculateValue =
                    operator.calculate.invoke(result, BigDecimal(calculatorContent[index + 1]))
                calculateValue.also { result = calculateValue }
            }

            if (validator.isOperator(inputString).not()) {
                validator.isNumeric(inputString)
            }
        }.run {
            result
        }
    }

}