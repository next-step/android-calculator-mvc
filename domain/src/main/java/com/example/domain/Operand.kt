package com.example.domain

enum class Operand(val operand: String) : IOperand {
    PLUS("+") {
        override fun calculate(firstNumber: Float, secondNumber: Float) = firstNumber + secondNumber
    },
    SUBTRACTION("-") {
        override fun calculate(firstNumber: Float, secondNumber: Float) = firstNumber - secondNumber
    },
    MULTIPLICATION("*") {
        override fun calculate(firstNumber: Float, secondNumber: Float) = firstNumber * secondNumber
    },
    DIVISION("/") {
        override fun calculate(firstNumber: Float, secondNumber: Float) = firstNumber / secondNumber
    },
    ;

    companion object {

        fun check(operand: String) = values().find { it.operand == operand } != null

        fun get(operand: String) = values().find { it.operand == operand }

        fun calculate(firstNumber: Float, operand: Operand, secondNumber: Float) =
            operand.calculate(firstNumber, secondNumber)
    }
}

interface IOperand {

    fun calculate(firstNumber: Float, secondNumber: Float): Float
}

