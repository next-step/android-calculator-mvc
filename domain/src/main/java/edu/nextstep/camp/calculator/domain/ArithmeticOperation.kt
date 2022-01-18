package edu.nextstep.camp.calculator.domain

enum class ArithmeticOperation {
    PLUS,
    MINUS,
    MULTIPLICATION,
    DIVISION;

    companion object {
        fun String.convertToArithmeticOperation(): ArithmeticOperation {
            when(this) {
                "+" -> return PLUS
                "-" -> return MINUS
                "*" -> return MULTIPLICATION
                "/" -> return DIVISION
            }

            throw IllegalArgumentException()
        }
    }
}
