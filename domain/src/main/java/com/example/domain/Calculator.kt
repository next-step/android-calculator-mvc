package com.example.domain

class Calculator {
    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank()) throw IllegalArgumentException()
        var currentValue = 0
        expression.split(" ").forEach { chunk ->
            var currentOperation: Operation? = null
            ExpressionElement.parse(chunk).forEach {
                when (it) {
                    is Operation -> currentOperation = it
                    is Operand -> currentValue = currentOperation?.let { operation ->
                        updateValue(operation, Operand(currentValue), it).toInt()
                    } ?: it.toInt()
                }
            }
        }
        return currentValue
    }

    fun updateValue(operation: Operation, operandA: Operand, operandB: Operand): Operand {
        return when (operation) {
            is Operation.Add -> add(operandA, operandB)
            is Operation.Subtract -> subtract(operandA, operandB)
            is Operation.Multiply -> multiply(operandA, operandB)
            is Operation.Divide -> divide(operandA, operandB)
        }
    }

    fun add(operandA: Operand, operandB: Operand): Operand = operandA + operandB

    fun subtract(operandA: Operand, operandB: Operand): Operand = operandA - operandB

    fun multiply(operandA: Operand, operandB: Operand): Operand = operandA * operandB

    fun divide(operandA: Operand, operandB: Operand): Operand = operandA / operandB
}

sealed class ExpressionElement {
    companion object {
        fun parse(rawExpression: String): List<ExpressionElement> {
            return rawExpression.map {
                when (it) {
                    '+' -> Operation.Add
                    '-' -> Operation.Subtract
                    '*' -> Operation.Multiply
                    '/' -> Operation.Divide
                    else -> it.digitToIntOrNull()?.let { value ->
                        Operand(value)
                    } ?: throw IllegalArgumentException()
                }
            }
        }
    }
}

sealed class Operation : ExpressionElement() {
    object Add : Operation()
    object Subtract : Operation()
    object Multiply : Operation()
    object Divide : Operation()
}

class Operand(private val value: Int) : ExpressionElement() {
    operator fun plus(other: Operand): Operand = Operand(this.value + other.value)
    operator fun minus(other: Operand): Operand = Operand(this.value - other.value)
    operator fun times(other: Operand): Operand = Operand(this.value * other.value)
    operator fun div(other: Operand): Operand = Operand(this.value / other.value)
    fun toInt(): Int = value
}
