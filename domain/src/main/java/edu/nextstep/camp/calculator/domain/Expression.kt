package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.util.CalculatorInputUtil

object Expression {
    var express: String = ""
    fun addNumber(input: String) {
        if (express.isEmpty()) {
            express = input
            return
        }

        if(input.isEmpty() || input.isBlank()){
            return
        }
        express = if (express.isNotEmpty() &&
            CalculatorInputUtil.isNumberRegex(express.last().toString())
        ) {
            "$express$input"
        } else {
            "$express,$input"
        }
    }

    fun addOperator(input: String) {
        if (express.isEmpty()) {
            express = ""
            return
        }
        if(input.isEmpty() || input.isBlank()){
            return
        }
        express = if (express.isNotEmpty() &&
            CalculatorInputUtil.isNumberRegex(express.last().toString())
        ) {
            "$express,$input"
        } else {
            ""
        }
    }

    fun getResult(): Int {
        val operandArray = express.split(",").filter {
            it != " " && it != ""
        }
        return Calculator.calculate(operandArray)
    }

    fun reset() {
        express = ""
    }
}