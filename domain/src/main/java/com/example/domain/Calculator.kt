package com.example.domain

class Calculator {
    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank()) throw IllegalArgumentException()
        var currentValue = 0
        expression.split(" ").forEach { chunk ->
            currentValue = calculate(currentValue, chunk)
        }
        return currentValue
    }

    fun calculate(currentValue: Int, expression: String): Int {
        var currentOperation: Operation? = null
        var currentValue = currentValue
        expression.forEach {
            when (it) {
                '+' -> currentOperation = Operation.Add
                '-' -> currentOperation = Operation.Subtract
                '*' -> currentOperation = Operation.Multiply
                '/' -> currentOperation = Operation.Divide
                else ->
                    currentValue = if (it.isDigit()) {
                        updateValue(currentOperation, currentValue, it.digitToInt())
                    } else {
                        throw IllegalArgumentException()
                    }
            }
        }
        return currentValue
    }

    fun updateValue(operation: Operation?, operandA: Int, operandB: Int): Int {
        return when (operation) {
            is Operation.Add -> add(operandA, operandB)
            is Operation.Subtract -> subtract(operandA, operandB)
            is Operation.Multiply -> multiply(operandA, operandB)
            is Operation.Divide -> divide(operandA, operandB)
            else -> operandB
        }
    }

    fun add(operandA: Int, operandB: Int): Int = operandA + operandB

    fun subtract(operandA: Int, operandB: Int): Int = operandA - operandB

    fun multiply(operandA: Int, operandB: Int): Int = operandA * operandB

    fun divide(operandA: Int, operandB: Int): Int = operandA / operandB
}

sealed class Operation {
    object Add : Operation()
    object Subtract : Operation()
    object Multiply : Operation()
    object Divide : Operation()
}
