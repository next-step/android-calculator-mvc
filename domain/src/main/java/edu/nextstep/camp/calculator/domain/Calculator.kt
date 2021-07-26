package edu.nextstep.camp.calculator.domain

object Calculator {
    fun calculate(operationExpression: String): Double {
        val operatorCodes = Operator.getOperatorCodes().toTypedArray()

        val (operandList, operatorList) = StringConverter(operatorCodes)
            .convert(expression = operationExpression)

        var result = operandList.first()
        operatorList.forEachIndexed { index, operator ->
            result = operator.calculate(result, operandList[index + 1])
        }
        return result
    }
}