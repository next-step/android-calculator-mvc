package edu.nextstep.camp.calculator.domain

class ExpressionParser {

    fun parse(expression: String): Expression {
        val signList = findSigns(expression)
        val numberList = findNumbers(expression)

        return Expression(
            numberList = numberList,
            signList = signList
        )
    }

    private fun findSigns(expression: String): List<Sign> {
        return """[^0-9 ]""".toRegex()
            .findAll(expression)
            .map(::findMappedSign)
            .toList()
    }

    private fun findMappedSign(result: MatchResult): Sign {
        return when (result.value) {
            "+" -> Sign.PLUS
            "-" -> Sign.MINUS
            "*" -> Sign.TIMES
            "/" -> Sign.DIVISION
            else -> throw IllegalArgumentException("수식에는 +, -, *, /만 사용될 수 있습니다.")
        }
    }

    private fun findNumbers(expression: String): List<Int> {
        return """[^0-9 ]""".toRegex()
            .split(expression)
            .map {
                if (it.isBlank()) throw IllegalArgumentException("수식은 연속된 연산자를 포함할 수 없습니다.")
                it.trim().toIntOrNull() ?: throw IllegalArgumentException("수식은 연속된 피연산자를 포함할 수 없습니다.")
            }
    }
}
