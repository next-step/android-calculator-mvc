package edu.nextstep.camp.calculator.domain

import java.util.*

internal class Calculation {
    fun calculate(tokens: List<Token>): Result<Int> = runCatching {
        val queue: Queue<Token> = LinkedList(tokens)
        val operand1 = queue.poll()
        check(operand1 is Operand)
        var result: Int = operand1.operand
        while (queue.isNotEmpty()) {
            val operator = queue.poll()
            check(operator is Operator)
            val operand2 = queue.poll()
            check(operand2 is Operand)
            result = Expression(operand1.operand, operand2.operand, operator).expose()
        }
        result
    }
}
