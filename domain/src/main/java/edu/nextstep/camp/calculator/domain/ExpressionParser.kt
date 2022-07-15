package edu.nextstep.camp.calculator.domain

class ExpressionParser {

    fun parse(expression: String): List<Symbol> {
        return expression.split(' ')
            .map { symbol ->
                when (symbol) {
                    "+" -> Symbol.Sign.PLUS
                    "-" -> Symbol.Sign.MINUS
                    "*" -> Symbol.Sign.TIMES
                    "/" -> Symbol.Sign.DIVISION
                    else -> symbol.toIntOrNull()?.let {
                        Symbol.Number(it)
                    } ?: throw IllegalArgumentException("수식에는 +, -, *, /만 사용될 수 있습니다.")
                }
            }
    }
}
