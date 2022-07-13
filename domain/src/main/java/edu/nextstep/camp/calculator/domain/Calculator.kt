package edu.nextstep.camp.calculator.domain

class Calculator {

    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank())
            throw IllegalArgumentException("null 또는 빈 공백 문자열은 수식이 아닙니다.")
        if (containsInvalidSymbol(expression))
            throw IllegalArgumentException("수식에는 +, -, *, /만 사용될 수 있습니다.")

        return evaluateSymbols(splitToSymbols(expression))
    }

    private fun containsInvalidSymbol(expression: String): Boolean {
        return expression.matches(""".*[^0-9+\-*/ ].*""".toRegex())
    }

    private fun splitToSymbols(expression: String): List<String> {
        return expression.split(' ')
    }

    private fun evaluateSymbols(symbols: List<String>): Int {
        var sign: String? = null

        return symbols.fold(0) { prevResult, symbol ->
            if ("+-*/".contains(symbol)) {
                sign = symbol
                return@fold prevResult
            }

            evaluateOne(prevResult, sign, symbol.toInt())
        }
    }

    private fun evaluateOne(prevResult: Int, sign: String?, number: Int): Int {
        return when (sign) {
            "+" -> prevResult + number
            "-" -> prevResult - number
            "*" -> prevResult * number
            "/" -> prevResult / number
            else -> number
        }
    }
}
