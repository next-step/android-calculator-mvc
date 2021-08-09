package edu.nextstep.camp.domain.stringcalculator

/**
 * Created By Malibin
 * on 7월 23, 2021
 */

object StringCalculator {

    fun calculate(expression: String): Int {
        validateNotEmptyExpression(expression)
        val tokens = StringTokens.from(expression)

        var result = tokens[0].toOperand()
        for (i in 1 until tokens.size step 2) {
            val operator = Operator.find(tokens[i])
            val operand = tokens[i + 1].toOperand()
            result = operator.calculate(result, operand)
        }
        return result.value
    }

    private fun validateNotEmptyExpression(expression: String) {
        require(expression.trim().isNotEmpty()) { "빈 수식은 계산할 수 없습니다." }
    }

    private fun String.toOperand(): Operand {
        return try {
            Operand(this)
        } catch (e: Exception) {
            throw IllegalArgumentException("수식의 숫자 자리에 숫자가 아닌 문자 ($this)가 존재합니다.")
        }
    }
}
