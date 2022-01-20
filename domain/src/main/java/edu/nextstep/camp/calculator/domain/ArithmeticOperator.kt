package edu.nextstep.camp.calculator.domain

enum class ArithmeticOperator(val operation: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("×"),
    DIVISION("÷");

    companion object {
        fun convertToArithmeticOperation(operation: String): ArithmeticOperator {
            return values().find { it.operation == operation } ?: throw IllegalArgumentException()
        }

        fun ArithmeticOperator.calculate(firstNumber: Double, secondNumber: Double): Double {
            return when (this) {
                PLUS -> firstNumber + secondNumber
                MINUS -> firstNumber - secondNumber
                MULTIPLICATION -> firstNumber * secondNumber
                DIVISION -> firstNumber / secondNumber
            }
        }
    }
}
