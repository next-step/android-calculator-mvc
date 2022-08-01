package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluate(tokens: List<Token>): Int {
        require(tokens.isNotEmpty()) { "input's value is not empty" } // 입력값이 빈 공백 문자일 경우 IllegalArgumentException
        return calculate(tokens).getOrThrow()
    }

    private fun calculate(tokens: List<Token>): Result<Int> = runCatching {
        val operand1 = tokens[0]
        check(operand1 is Operand) { "$operand1 is not Operator" }
        var result: Operand = operand1
        for (i in 1 until tokens.size step 2) {
            check(tokens.size - 1 >= i + 1) { " token's size must be more than ${i + 1} " }
            val operator = tokens[i]
            check(operator is Operator) { "$operator is not Operator" }
            val operand2 = tokens[i + 1]
            check(operand2 is Operand) { "$operand2 is not Operator" }
            result = Operand(operator.operate(result.operand, operand2.operand))
        }
        result.operand
    }.onFailure {
        throw IllegalArgumentException("invalid tokens $tokens")
    }
}
