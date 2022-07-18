package edu.nextstep.camp.calculator.domain

class Calculator {

    fun evaluate(inputExpression: String?): Int {
        require(!inputExpression.isNullOrBlank()) { "입력값은 null이거나 빈값일 수 없습니다." }

        val expressionNodeList = Splitter.split(inputExpression)

        val firstNode = expressionNodeList.first()

        if (expressionNodeList.size % 2 != 1 || firstNode is Operator)
            throw IllegalArgumentException("정상적인 식이 아닙니다.")

        //이전 연산 결과값을 저장
        var result = (firstNode as Operand).value

        for (i in 1 until expressionNodeList.size step 2) {
            val operator = expressionNodeList[i]
            val operand = expressionNodeList[i + 1]

            if (operator is Operator && operand is Operand) {
                result = operator.calculate(result, operand.value)
            } else {
                throw IllegalArgumentException("정상적인 식이 아닙니다.")
            }
        }

        return result
    }

}