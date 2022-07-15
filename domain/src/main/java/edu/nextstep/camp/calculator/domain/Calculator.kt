package edu.nextstep.camp.calculator.domain

class Calculator(
    private val expressionParser: ExpressionParser = ExpressionParser()
) {

    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank())
            throw IllegalArgumentException("null 또는 빈 공백 문자열은 수식이 아닙니다.")

        val symbolList = expressionParser.parse(expression)
        TODO("변경된 파서 반영")
//        return evaluateSymbols(symbolList)
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
