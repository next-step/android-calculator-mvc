package edu.nextstep.camp.calculator

class Separator {

    fun getNumbers(expression: String): List<Number> {
        return expression.split("+", "-", "×", "÷")
            .map { Number(it) }
    }

    fun getOperators(expression: String): List<Operator> {
        return expression.filter { Operator.OPERATORS.contains(it.toString()) }
            .map { Operator(it.toString()) }
    }
}