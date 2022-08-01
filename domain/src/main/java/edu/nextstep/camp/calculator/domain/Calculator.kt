package edu.nextstep.camp.calculator.domain

import java.util.*

class Calculator {
    fun evaluate(tokens: List<Token>): Int {
        require(tokens.isNotEmpty()) { "input's value is not empty" } // 입력값이 빈 공백 문자일 경우 IllegalArgumentException
        return calculate(tokens).getOrThrow()
    }

    private fun calculate(tokens: List<Token>): Result<Int> = runCatching {
        val queue: Queue<Token> = LinkedList(tokens)
        val operand1 = queue.poll()
        check(operand1 is Operand)
        var result: Expression = Expression.Value(operand1.operand)
        while (queue.isNotEmpty()) {
            val operator = queue.poll()
            check(operator is Operator)
            val operand2 = queue.poll()
            check(operand2 is Operand)
            result = Expression.Calculation(
                result,
                Expression.Value(operand2.operand),
                operator
            )
        }
        result.execute()
    }.onFailure {
        throw IllegalArgumentException("invalid tokens $tokens")
    }
}
