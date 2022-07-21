package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.util.CalculatorInputUtil

object Calculator {
    fun calculate(operands: List<String>): Int {
        var accumulated = operands.first().toInt()
        var operatorMark = ""
        operands.forEach { text ->
            if (operatorMark.isNotEmpty() && CalculatorInputUtil.isNumberRegex(text)) {
                accumulated = Operator
                    .getOperated(
                        accumulated = accumulated,
                        nextInt = text.toInt(),
                        operatorMark = operatorMark
                    )
                return@forEach
            }
            operatorMark = text
        }
        return accumulated
    }
}
