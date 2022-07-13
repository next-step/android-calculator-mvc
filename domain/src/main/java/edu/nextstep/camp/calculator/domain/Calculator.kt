package edu.nextstep.camp.calculator.domain

class Calculator {

    fun evaluate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("null 또는 빈 공백 문자열은 수식이 아닙니다.")
        }

        if (""".*[^0-9+\-*/ ].*""".toRegex().matches(expression)) {
            throw IllegalArgumentException("수식에는 +, -, *, /만 사용될 수 있습니다.")
        }

        val symbols = expression.split(' ')
        var result = 0
        var sign: String? = null

        symbols.forEach { symbol ->
            when (symbol) {
                "+", "-", "*", "/" -> sign = symbol
                else -> {
                    val number = symbol.toInt()
                    when (sign) {
                        "+" -> result += number
                        "-" -> result -= number
                        "*" -> result *= number
                        "/" -> result /= number
                        null -> result = number
                    }
                }
            }
        }

        return result
    }
}
