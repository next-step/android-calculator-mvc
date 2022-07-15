package edu.nextstep.camp.calculator.domain

class ExpressionParser {

    fun parse(expression: String): Expression {
        val signList = """[^0-9 ]""".toRegex()
            .findAll(expression)
            .map {
                when (it.value) {
                    "+" -> Symbol.Sign.PLUS
                    "-" -> Symbol.Sign.MINUS
                    "*" -> Symbol.Sign.TIMES
                    "/" -> Symbol.Sign.DIVISION
                    else -> throw IllegalArgumentException("수식에는 +, -, *, /만 사용될 수 있습니다.")
                }
            }
            .toList()

        val numberList = """[^0-9 ]""".toRegex()
            .split(expression)
            .map {
                if (it.isBlank()) throw IllegalArgumentException("수식은 연속된 기호를 포함할 수 없습니다.")
                it.trim().toInt()
            }

        return Expression(
            numberList = numberList,
            signList = signList
        )
    }
}
