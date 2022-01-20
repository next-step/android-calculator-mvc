package com.example.domain

class Calculator {
    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank()) throw IllegalArgumentException()
        var currentValue = 0
        var currentOperation: Operation? = null
        expression.split(" ")
            .map(ExpressionElement::parse)
            .forEach { expressionElement ->
                when (expressionElement) {
                    is Operation -> currentOperation = expressionElement
                    is Operand -> currentValue = currentOperation?.let { operation ->
                        updateValue(operation, Operand(currentValue), expressionElement).toInt()
                    } ?: expressionElement.toInt()
                }
            }
        return currentValue
    }

    fun updateValue(operation: Operation?, operandA: Operand, operandB: Operand): Operand {
        return when (operation) {
            is Operation.Add -> add(operandA, operandB)
            is Operation.Subtract -> subtract(operandA, operandB)
            is Operation.Multiply -> multiply(operandA, operandB)
            is Operation.Divide -> divide(operandA, operandB)
            else -> operandB
        }
    }

    fun add(operandA: Operand, operandB: Operand): Operand = operandA + operandB

    fun subtract(operandA: Operand, operandB: Operand): Operand = operandA - operandB

    fun multiply(operandA: Operand, operandB: Operand): Operand = operandA * operandB

    fun divide(operandA: Operand, operandB: Operand): Operand = operandA / operandB
}

sealed class ExpressionElement {
    companion object {
        fun parse(rawExpression: String): ExpressionElement {
            return when (rawExpression) {
                "+" -> Operation.Add
                "-" -> Operation.Subtract
                "*" -> Operation.Multiply
                "/" -> Operation.Divide
                else -> rawExpression.toIntOrNull()?.let { value ->
                    Operand(value)
                } ?: throw IllegalArgumentException()
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
