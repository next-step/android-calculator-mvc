package com.example.domain

class Expression {
    private val componentList = mutableListOf<String>()
    private val operatorList = listOf("+", "-", "×", "÷")

    fun addComponent(element: String) = componentList.add(element)
    fun removeLastComponent() = componentList.removeLast()

    fun appendNumber(number: String) {
        when {
            isEmpty() -> addComponent(number)
            endsWithOperator() -> addComponent(number)
            endsWithOperand() -> updateLastOperand(number)
        }
    }

    fun appendOperator(operator: String) {
        when {
            isEmpty() -> {
                // no-op
            }
            endsWithOperator() -> replaceLastElement(operator)
            endsWithOperand() -> addComponent(operator)
        }
    }

    fun isEmpty() = componentList.isEmpty()

    fun getLast() = componentList.last()

    fun endsWithOperator() = operatorList.contains(getLast())

    fun endsWithOperand() = (getLast().toIntOrNull() != null)

    private fun updateLastOperand(partial: String) {
        val lastOperand = componentList.removeLast()
        val updatedLastOperand = lastOperand + partial
        addComponent(updatedLastOperand)
    }

    private fun replaceLastElement(lastToBe: String) {
        componentList.removeLast()
        addComponent(lastToBe)
    }

    fun replaceToResult(result: String) {
        componentList.clear()
        componentList.add(result)
    }

    fun removeLast() {
        when {
            isEmpty() -> {
                // no-op
            }
            endsWithOperator() -> removeLastComponent()
            endsWithOperand() -> replaceLastElement(getLast().dropLast(1))
        }
    }

    fun getExpression(delimiter: String = " "): String {
        val expression = componentList.joinToString(delimiter)
        if (expression.lastOrNull()?.isWhitespace() == true) return expression.trimEnd()
        return expression
    }
}
