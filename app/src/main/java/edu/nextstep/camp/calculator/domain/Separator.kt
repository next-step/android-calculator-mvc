package edu.nextstep.camp.calculator.domain

class Separator {
    fun getNumbers(expression: String): List<Number> {
        return expression.split("+", "-", "×", "÷")
                .map { Number(it) }
    }

    fun getOperators(expression: String): List<Operator> {
        return expression.filter { Operator.isOperator(it.toString()) }
                .map { Operator.of(it.toString()) }
    }
}