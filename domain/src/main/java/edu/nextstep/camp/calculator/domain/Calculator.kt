package edu.nextstep.camp.calculator.domain

import java.util.*

class Calculator {
    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("expression must not be null")
        }

        val exp = parse(tokenize(expression))
        return exp.evaluate()
    }

    private fun tokenize(expression: String): List<String> {
        // 공백으로 구분된 문자열을 입력 받아야한다.
        return expression.split(" ").map { it.trim() }
    }

    private fun parse(_tokens: List<String>): Expression {
        val tokens = ArrayDeque(_tokens)
        var expression: Expression = ValueNode(tokens.pop().toInt())

        while (tokens.isNotEmpty()) {
            val op = tokens.pop()
            // TODO: 이 과정에서 에러가 발생할 수 있는데, 이는 포맷이 잘못되었다는 뜻이다.
            val operand = ValueNode(tokens.pop().toInt())

            expression = ExpressionNode(expression, operand, op)
        }

        return expression
    }
}

