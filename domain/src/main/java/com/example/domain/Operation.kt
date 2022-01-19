package com.example.domain

enum class Operation(val operation: String) : IOperation {
    PLUS("+") {
        override fun calculate(input1: Float, input2: Float) = input1 + input2
    },
    SUBTRACTION("-") {
        override fun calculate(input1: Float, input2: Float) = input1 - input2
    },
    MULTIPLICATION("*") {
        override fun calculate(input1: Float, input2: Float) = input1 * input2
    },
    DIVISION("/") {
        override fun calculate(input1: Float, input2: Float) = input1 / input2
    },
    ;

    companion object {

        fun check(operation: String) = values().find { it.operation == operation } != null

        fun get(operation: String) = values().find { it.operation == operation }

        fun calculate(input1: Float, operator: Operation, input2: Float) =
            operator.calculate(input1, input2)
    }
}

interface IOperation {

    fun calculate(input1: Float, input2: Float): Float
}

