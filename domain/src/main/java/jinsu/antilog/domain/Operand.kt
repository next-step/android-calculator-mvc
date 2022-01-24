package jinsu.antilog.domain

data class Operand(
    private val operand: String
) : ExpressionLetters {
    fun toDouble(): Double {
        require(operand.toDoubleOrNull() is Double) {
            "$operand 는 피연산자가 될 수 없습니다."
        }
        return operand.toDouble()
    }
}