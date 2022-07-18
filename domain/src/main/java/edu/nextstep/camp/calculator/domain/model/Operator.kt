package edu.nextstep.camp.calculator.domain.model

enum class Operator(override val value: String?) : ExpressionToken {
    ADDITION("+") {
        override fun evaluate(firstOperand: Operand, secondOperand: Operand): Operand = firstOperand + secondOperand
    },
    SUBTRACTION("-") {
        override fun evaluate(firstOperand: Operand, secondOperand: Operand): Operand = firstOperand - secondOperand
    },
    MULTIPLICATION("×") {
        override fun evaluate(firstOperand: Operand, secondOperand: Operand): Operand = firstOperand * secondOperand
    },
    DIVISION("÷") {
        override fun evaluate(firstOperand: Operand, secondOperand: Operand): Operand = firstOperand / secondOperand
    },
    UNKNOWN(null) {
        override fun evaluate(firstOperand: Operand, secondOperand: Operand): Operand {
            throw IllegalArgumentException("Unknown Operator")
        }
    };

    abstract fun evaluate(firstOperand: Operand, secondOperand: Operand) : Operand

    companion object {
        fun getFromRaw(raw: String) : Operator {
            return when (raw) {
                ADDITION.value -> ADDITION
                SUBTRACTION.value -> SUBTRACTION
                MULTIPLICATION.value -> MULTIPLICATION
                DIVISION.value -> DIVISION
                else -> UNKNOWN
            }
        }
    }
}
