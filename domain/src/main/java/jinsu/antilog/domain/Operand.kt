package jinsu.antilog.domain

data class Operand(
    private val operand: String
) : ExpressionLetter {

    private var _value: Int = 0

    init {
        require(operand.toIntOrNull() is Int) {
            "$operand 는 피연산자가 될 수 없습니다."
        }
        this._value = operand.toInt()
    }

    fun toDouble() = _value.toDouble()

    override fun toString(): String = "${this._value}"

    fun addLastLetter(operand: Operand) {
        val tens = this._value * PLACE_VALUE
        val units = operand._value
        _value = (tens + units)
    }

    fun removeLastLetter(): Unit? {
        val removeUnitsValue = this._value / PLACE_VALUE
        if (removeUnitsValue < 1) return null
        _value = removeUnitsValue
        return Unit
    }

    companion object {
        private const val PLACE_VALUE = 10
    }
}
