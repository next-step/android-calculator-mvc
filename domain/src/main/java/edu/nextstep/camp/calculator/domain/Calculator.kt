package edu.nextstep.camp.calculator.domain

object Calculator {
    fun calculate(operationExpression: String): Double {

        val operatorCodes = Operator.getOperatorCodes().toTypedArray()
        val operandList = operationExpression.split(*operatorCodes).map(String::toDouble)
        val operatorList = operationExpression.map(Char::toString)
            .filter { operatorCodes.contains(it) }
            .map { Operator.getOperator(it) }

        var result = operandList.first()
        operatorList.forEachIndexed { index, operator ->
            result = operator.calculate(result, operandList[index + 1])
        }
        return result
    }
}
