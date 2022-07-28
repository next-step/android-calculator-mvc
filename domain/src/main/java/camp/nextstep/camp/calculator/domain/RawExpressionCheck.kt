package camp.nextstep.camp.calculator.domain

class RawExpressionCheck {

    fun checkNullOrBlank(rawExpression: String?) {
        if (rawExpression.isNullOrBlank()) throw IllegalArgumentException()
    }

    fun checkNumber(operand: String) {
        if (!isNumeric(operand)) throw NumberFormatException("입력된 표현식이 올바르지 않습니다.")
    }

    private fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }
}