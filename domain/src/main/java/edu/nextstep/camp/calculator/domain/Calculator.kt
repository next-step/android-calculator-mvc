package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluatesExpression(expression: String?): Double{
        if(expression.isNullOrBlank()) throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자")

        val inputList = expression.split(" ")

        var result = inputList[0].toDouble()
        for(i in 1 until inputList.size step(2)){
            val operator = inputList[i]
            val operand = inputList[i+1].toDouble()

            result = Operator.get(operator).calculate(result, operand)
        }
        return result
    }
}