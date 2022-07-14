package edu.nextstep.calculator.domain

class Calculator {
    val expressionContents: List<String>
        get() = _expressionContents
    private val _expressionContents = mutableListOf<String>()

    private val operation = listOf("+", "-", "*", "/")

    fun input(expression: String?) {
        require(!expression.isNullOrBlank()) {
            "입력값이 null이거나 빈 공백 문자입니다."
        }

        _expressionContents.clear()
        _expressionContents.addAll(splitExpression(expression))
    }

    private fun splitExpression(expression: String): List<String> {
        val expressionContents = expression.split(" ")
        isValidExpression(expressionContents)
        return expressionContents
    }

    private fun isValidExpression(expressionContents: List<String>) {
        expressionContents.forEach { content ->
            if (isNumber(content)) {
                return@forEach
            }

            checkOperation(content)
        }
    }

    private fun isNumber(content: String): Boolean {
        val isIntRegex = Regex("-?\\d+")

        return content.matches(isIntRegex)
    }

    private fun checkOperation(content: String) {
        require(operation.contains(content)) {
            "사칙연산 기호가 아닙니다"
        }
    }

    fun calculate(): Int {
        var result = _expressionContents.first().toInt()
        var operation = ""
        _expressionContents.forEach { content ->
            if (this.operation.contains(content)) {
                operation = content
                return@forEach
            }
            result = calculateExpression(first = result, second = content.toInt(), operation = operation)
        }

        return result
    }

    private fun calculateExpression(first: Int, second: Int, operation: String): Int {
        return when (operation) {
            "+" -> plus(first = first, second = second)
            "-" -> minus(first = first, second = second)
            "*" -> multiply(first = first, second = second)
            "/" -> divide(first = first, second = second)
            else -> first
        }
    }

    private fun plus(first: Int, second: Int): Int = first + second
    private fun minus(first: Int, second: Int): Int = first - second
    private fun multiply(first: Int, second: Int): Int = first * second
    private fun divide(first: Int, second: Int): Int = first / second
}
