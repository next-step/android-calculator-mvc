package edu.nextstep.camp.calculator.domain

class ExpressionParser {

    fun parse(expression: String): Expression {
        val symbolList = expression.split(" ")
        return Expression(
            numberList = symbolList
                .filterIndexed { i, _ -> i % 2 == 0 }
                .map { it.toInt() },
            signList = symbolList
                .filterIndexed { i, _ -> i % 2 == 1 }
                .map { sign ->
                    when (sign) {
                        "+" -> Symbol.Sign.PLUS
                        "-" -> Symbol.Sign.MINUS
                        "*" -> Symbol.Sign.TIMES
                        "/" -> Symbol.Sign.DIVISION
                        else -> throw IllegalArgumentException("수식에는 +, -, *, /만 사용될 수 있습니다.")
                    }
                }
        )
    }
}
