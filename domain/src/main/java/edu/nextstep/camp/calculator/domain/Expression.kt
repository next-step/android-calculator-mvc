package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.util.CalculatorInputUtil

object Expression {
    var express: String = ""

    fun addNumber(input: String) {
        if (express.isEmpty()) {
            express = input
            return
        }

        if (input.isEmpty() || input.isBlank()) {
            return
        }
        express = if (express.isNotEmpty() &&
            CalculatorInputUtil.isNumberRegex(express.last().toString())
        ) {
            "$express$input"
        } else {
            "$express $input"
        }
    }

    fun addOperator(input: String) {
        if (express.isEmpty()) {
            express = ""
            return
        }
        if (input.isEmpty() || input.isBlank()) {
            return
        }
        express = if (express.isNotEmpty() &&
            CalculatorInputUtil.isNumberRegex(express.last().toString())
        ) {
            "$express $input"
        } else {
            ""
        }
    }

    fun delete() {
        if (express.isEmpty()) {
            express = ""
            return
        }
        if(CalculatorInputUtil.isOperationMarkRegex(express.last().toString())){
           express = express.dropLast(2)
            return
        }
        express = express.dropLast(1)
    }

    fun getResult(): Int {
        if (CalculatorInputUtil.isOperationMarkRegex(express.last().toString())) {
            throw IllegalArgumentException("유효하지 않은 수식입니다.")
        }
        val operandArray = express.split(" ").filter {
            it.isNotBlank() && it.isNotEmpty()
        }
        express = Calculator.calculate(operandArray).toString()
        return Calculator.calculate(operandArray)
    }
}