package edu.nextstep.camp.calculator.domain

enum class ArithmeticSign(val operation: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("×"),
    DIVISION("÷");

    companion object {
        fun convertToArithmeticOperation(operation: String): ArithmeticSign {
            return values().find { it.operation == operation } ?: throw IllegalArgumentException()
        }

        fun ArithmeticSign.calculate(firstOperand: Double, secondOperand: Double): Double {
            return when (this) {
                PLUS -> firstOperand + secondOperand
                MINUS -> firstOperand - secondOperand
                MULTIPLICATION -> firstOperand * secondOperand
                DIVISION -> firstOperand / secondOperand
            }
        }
    }
}
