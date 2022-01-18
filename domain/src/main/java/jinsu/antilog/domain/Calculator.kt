package jinsu.antilog.domain

class Calculator {
    fun calculate(expressionString: String?): Double {
        val expression = expressionString.toCalculationList().also {
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


    private fun String?.toCalculationList(): List<String> {
        if (this.isNullOrBlank()) throw IllegalArgumentException("전달 받은 문자열이 Null 이거나 공백일 수 없습니다.")
        return this.split(" ")
    }

    private fun validateExpression(expression: List<String>) {
        require(expression.size > 2) {
            throw IllegalArgumentException("입력받은 값은 수식이 아닙니다.")
        }
    }
}