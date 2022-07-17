package com.soolee.domain

import com.soolee.domain.util.CalculatorInputUtil

class Calculator {
    fun calculate(input: String): Int {
        var accumulated = 0
        var operationMark = ""

        Generator.getCaculatorInputToTextArr(input).forEach { text ->
            if (CalculatorInputUtil.isNumberRegex(text)) {
                accumulated = Operator
                    .getOperated(
                        accumulated,
                        text.toInt(),
                        operationMark
                    )
            } else {
                operationMark = text
                return@forEach
            }
            println(accumulated)
        }
        return accumulated
    }
}
