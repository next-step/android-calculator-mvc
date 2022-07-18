package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.util.CalculatorInputUtil

class Calculator {
    fun calculate(inputTextArray: List<String>): Int {
        var accumulated = 0
        var operatorMark = ""

        inputTextArray.forEach { text ->
            if (CalculatorInputUtil.isNumberRegex(text)) {
                accumulated = Operator
                    .getOperated(
                        accumulated = accumulated,
                        nextInt = text.toInt(),
                        operatorMark = operatorMark
                    )
            } else {
                operatorMark = text
                return@forEach
            }
        }
        return accumulated
    }
}
