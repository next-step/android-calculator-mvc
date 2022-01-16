package com.example.domain

class Calculator {
    fun evaluate(expression: String?): Int{
        if(expression.isNullOrEmpty()) throw IllegalArgumentException()
        var currentValue = 0
        expression.split(" ").forEach { chunk ->
            currentValue = calculate(currentValue, chunk)
        }
        return currentValue
    }

    fun calculate(currentValue: Int, chunk: String): Int {
        var currentOperation : Operation? = null
        var updatedValue : Int = currentValue
        chunk?.forEach {
            when(it){
                '+' -> currentOperation = Operation.Add
                '-' -> currentOperation = Operation.Subtract
                '*' -> currentOperation = Operation.Multiply
                '/' -> currentOperation = Operation.Divide
                else -> when(currentOperation){
                    is Operation.Add ->  updatedValue = add(updatedValue, it.digitToInt())
                    is Operation.Subtract ->  updatedValue = subtract(updatedValue, it.digitToInt())
                    is Operation.Multiply ->  updatedValue = multiply(updatedValue, it.digitToInt())
                    is Operation.Divide ->  updatedValue = divide(updatedValue, it.digitToInt())
                    else -> updatedValue = it.digitToIntOrNull() ?: throw IllegalArgumentException()
                }
            }
        }
        return updatedValue
    }

    fun add(operandA: Int, operandB: Int): Int = operandA + operandB

    fun subtract(operandA: Int, operandB: Int): Int = operandA - operandB

    fun multiply(operandA: Int, operandB: Int): Int = operandA * operandB

    fun divide(operandA: Int, operandB: Int): Int = operandA / operandB
}

sealed class Operation{
    object Add:Operation()
    object Subtract:Operation()
    object Multiply:Operation()
    object Divide:Operation()
}