package camp.nextstep.camp.calculator.domain

class RawExpressionCheck {

    fun isNullOrBlankCheck(rawExpression: String?) {
        if (rawExpression.isNullOrBlank()) throw IllegalArgumentException()
    }

    fun isNumericCheck(operand: String) {
        if(!isNumeric(operand)) throw NumberFormatException()
    }

    private fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }
}