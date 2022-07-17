package edu.nextstep.camp.calculator.domain

open class EvaluationException(message: String) : IllegalStateException(message)
class ExpressionParsingException(message: String) : EvaluationException(message)

internal class Parser {
    fun parse(tokens: List<Token>): Expression {
        try {
            val deque = ArrayDeque(tokens)

            val firstToken = deque.removeFirst()
            check(firstToken is Operand)
            var expression: Expression = ValueNode(firstToken.number)

            while (deque.isNotEmpty()) {
                val opToken = deque.removeFirst()
                check(opToken is Operator)
                val numberToken = deque.removeFirst()
                check(numberToken is Operand)
                expression = ExpressionNode(
                    left = expression,
                    right = ValueNode(numberToken.number),
                    op = opToken
                )
            }
            return expression
        } catch (e: Throwable) {
            throw ExpressionParsingException("invalid tokens -> $tokens")
        }
    }
}
