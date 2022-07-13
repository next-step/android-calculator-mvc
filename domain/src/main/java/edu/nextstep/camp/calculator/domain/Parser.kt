package edu.nextstep.camp.calculator.domain

class ExpressionParsingException(message: String) : IllegalArgumentException(message)

internal class Parser {
    fun parse(tokens: List<Token>): Expression {
        try {
            val deque = ArrayDeque(tokens)

            val firstToken = deque.removeFirst()
            check(firstToken is Number)
            var expression: Expression = ValueNode(firstToken.number)

            while (deque.isNotEmpty()) {
                val opToken = deque.removeFirst()
                check(opToken is Operator)
                val numberToken = deque.removeFirst()
                check(numberToken is Number)
                expression = ExpressionNode(
                    left = expression,
                    right = ValueNode(numberToken.number),
                    op = opToken.op
                )
            }
            return expression
        } catch (e: Throwable) {
            throw ExpressionParsingException("invalid tokens -> $tokens")
        }
    }
}
