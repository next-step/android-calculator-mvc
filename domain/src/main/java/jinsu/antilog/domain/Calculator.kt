package jinsu.antilog.domain

object Calculator {
    fun calculate(expressionString: String?): Double {
        val expression = expressionString?.split(" ").orEmpty().also {
            validateExpression(it)
        }
        var accumulator = StringOperand(expression[0]).toDouble()
        for (i in 1 until expression.size step 2) {
            val operator = Operator.findOperatorBySymbol(expression[i])
            val operand = StringOperand(expression[i + 1]).toDouble()
            accumulator = operator.operate(accumulator, operand)
        }
        return accumulator
    }

    private fun validateExpression(expression: List<String>) {
        require(expression.size > 2) {
            throw IllegalArgumentException("입력받은 값은 수식이 아닙니다.")
        }
    }
}