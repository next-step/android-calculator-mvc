package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.ArithmeticOperator.Companion.calculate

object Calculator {

    fun calculateContents(contents: String): Double {
        if (contents.isEmpty()) {
            throw IllegalArgumentException()
        }

        val initialNumberWithOperations = InputContentsClassifier.makeInitialNumberWithOperationsFromContents(contents)

        var firstOperand = initialNumberWithOperations.first
        val operations = initialNumberWithOperations.second

        operations.forEach { (operator, secondOperand) ->
            val arithmeticOperator = ArithmeticOperator.convertToArithmeticOperation(operator)
            firstOperand = arithmeticOperator.calculate(
                firstOperand,
                secondOperand.toDouble()
            )
        }

        return firstOperand
    }

    fun isRoundedNumber(number: Double): Boolean {
        val remainder = number.rem(-1)
        return remainder == 0.0
    }

    fun isNumber(content: String): Boolean {
        return content.toDoubleOrNull()?.let {
            true
        } == true
    }
}
