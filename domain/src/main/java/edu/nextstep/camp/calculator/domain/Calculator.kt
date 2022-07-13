package edu.nextstep.camp.calculator.domain


object Calculator {
    fun evaluate(expression: String) : Int =
        evaluateNonEmptyExpression(expression.filter { !it.isWhitespace() })

    private fun evaluateNonEmptyExpression(expression: String) : Int {
        if (!RegexUtils.checkExpressionIsValid(expression)) throw IllegalArgumentException("Wrong Format")
        val opsList = RegexUtils.getOperatorsList(expression)
        val numList = RegexUtils.getNumbersList(expression)

        var result = numList[0]

        numList.subList(1, numList.size).forEachIndexed { index, num ->
            result = evaluateCurrentOperation(result, num, opsList[index])
        }

        return result
    }

    private fun evaluateCurrentOperation(currNum: Int, numToOp: Int, op: String) : Int {
        return when (op) {
            "+" -> evaluateAddition(currNum, numToOp)
            "-" -> evaluateSubtraction(currNum, numToOp)
            "*" -> evaluateMultiplication(currNum, numToOp)
            "/" -> evaluateDivision(currNum, numToOp)
            else -> throw IllegalArgumentException("Unsupported Operator")
        }
    }

    fun evaluateAddition(currNum: Int, numToAdd: Int) = currNum + numToAdd
    fun evaluateSubtraction(currNum: Int, numToSubtract: Int) = currNum - numToSubtract
    fun evaluateMultiplication(currNum: Int, numToMultiply: Int) = currNum * numToMultiply
    fun evaluateDivision(currNum: Int, numToDivide: Int) = currNum / numToDivide
}
