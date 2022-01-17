package com.example.domain

enum class Operation(val operation: String) {
    PLUS("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    ;

    companion object {

        fun check(operation: String) = values().find { it.operation == operation } != null

        fun get(operation: String) = values().find { it.operation == operation }

        fun calculator(input1: Float, operator: Operation, input2: Float) = when (operator) {
            PLUS -> {
                input1 + input2
            }
            SUBTRACTION -> {
                input1 - input2
            }
            MULTIPLICATION -> {
                input1 * input2
            }
            DIVISION -> {
                input1 / input2
            }
        }
    }
}
