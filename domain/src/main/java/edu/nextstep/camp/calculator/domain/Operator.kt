package edu.nextstep.camp.calculator.domain

enum class Operator(val raw: String) {
    ADDITION("+") {
        override fun evaluate(firstOperand: Int, secondOperand: Int): Int = firstOperand + secondOperand
    },
    SUBTRACTION("-") {
        override fun evaluate(firstOperand: Int, secondOperand: Int): Int = firstOperand - secondOperand
    },
    MULTIPLICATION("*") {
        override fun evaluate(firstOperand: Int, secondOperand: Int): Int = firstOperand * secondOperand
    },
    DIVISION("/") {
        override fun evaluate(firstOperand: Int, secondOperand: Int): Int = firstOperand / secondOperand
    },
    UNKNOWN("") {
        override fun evaluate(firstOperand: Int, secondOperand: Int): Int {
            throw IllegalArgumentException("Unknown Operator")
        }
    };

    abstract fun evaluate(firstOperand: Int, secondOperand: Int) : Int

    companion object {
        fun getFromRaw(raw: String) : Operator {
            return when (raw) {
                ADDITION.raw -> ADDITION
                SUBTRACTION.raw -> SUBTRACTION
                MULTIPLICATION.raw -> MULTIPLICATION
                DIVISION.raw -> DIVISION
                else -> UNKNOWN
            }
        }
    }
}
