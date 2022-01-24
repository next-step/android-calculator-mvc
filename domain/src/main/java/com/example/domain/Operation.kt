package com.example.domain

enum class Operation(val operation: String) : IOperation {
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

        fun check(operation: String) = values().find { it.operation == operation } != null

        fun get(operation: String) = values().find { it.operation == operation }

        fun calculate(firstNumber: Float, operator: Operation, secondNumber: Float) =
            operator.calculate(firstNumber, secondNumber)
    }
}

interface IOperation {

    fun calculate(firstNumber: Float, secondNumber: Float): Float
}

