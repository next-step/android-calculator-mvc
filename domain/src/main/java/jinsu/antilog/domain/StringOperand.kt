package jinsu.antilog.domain

data class StringOperand(
    private val operand: String
) {

    fun toDouble(): Double {
        validateOf(operand.toDoubleOrNull() is Double)
        return operand.toDouble()
    }

    private fun validateOf(condition: Boolean) = require(condition){
        throw IllegalArgumentException("$operand 는 피연산자가 될 수 없습니다.")
    }

}