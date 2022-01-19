package edu.nextstep.camp.calculator.domain

enum class ArithmeticOperation {
    PLUS,
    MINUS,
    MULTIPLICATION,
    DIVISION;

    companion object {
        fun convertToArithmeticOperation(operation: String): ArithmeticOperation {
            when(operation) {
                "+" -> return PLUS
                "-" -> return MINUS
                "*" -> return MULTIPLICATION
                "/" -> return DIVISION
            }

            throw IllegalArgumentException()
        }
    }
}
