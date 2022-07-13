package edu.nextstep.camp.calculator.domain

class Calculator {

    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank())
            throw IllegalArgumentException("null 또는 빈 공백 문자열은 수식이 아닙니다.")

        return evaluateSymbols(splitToSymbols(expression))
    }

    private fun splitToSymbols(expression: String): List<Symbol> {
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

    private fun evaluateSymbols(symbols: List<Symbol>): Int {
        var sign: Symbol.Sign? = null

        return symbols.fold(Symbol.Number(0)) { prevResult, symbol ->
            when (symbol) {
                is Symbol.Sign -> {
                    sign = symbol
                    prevResult
                }
                is Symbol.Number -> {
                    evaluateOne(prevResult, sign, symbol)
                }
            }
        }.n
    }

    private fun evaluateOne(
        prevResult: Symbol.Number,
        sign: Symbol.Sign?,
        number: Symbol.Number,
    ): Symbol.Number {
        return when (sign) {
            Symbol.Sign.PLUS -> prevResult + number
            Symbol.Sign.MINUS -> prevResult - number
            Symbol.Sign.TIMES -> prevResult * number
            Symbol.Sign.DIVISION -> prevResult / number
            null -> number
        }
    }
}
