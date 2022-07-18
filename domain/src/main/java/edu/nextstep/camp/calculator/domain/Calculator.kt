package edu.nextstep.camp.calculator.domain

class Calculator {

    fun calculate(input: String): Double {
        require(!input.isEmpty())
        val inputs = input.split(" ")
        return executeFunction(inputs)
    }

    private fun executeFunction(inputs: List<String>): Double {
        var acc = inputs.first().toDouble()
        var index = 1
        while (index < inputs.size) {
            val operatorSymbol = inputs[index++]
            val operator = operatorSymbol.findOperatorBySymbol()
            val newValue = inputs[index++].toDouble()
            acc = operator.execute(acc, newValue)
        }
        return acc
    }

    private fun String.findOperatorBySymbol(): Operator = Operator.findBySymbol(this)
}