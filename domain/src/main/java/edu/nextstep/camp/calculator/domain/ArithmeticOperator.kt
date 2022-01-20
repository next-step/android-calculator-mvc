package edu.nextstep.camp.calculator.domain

enum class ArithmeticOperator(val operation: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    companion object {
        fun convertToArithmeticOperation(operation: String): ArithmeticOperator {
            return values().find { it.operation == operation } ?: throw IllegalArgumentException()
        }
    }
}
