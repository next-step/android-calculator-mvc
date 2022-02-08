package jinsu.antilog.domain

data class Operand(
    private var value: Int
) : ExpressionLetter {
    constructor(operand: String): this(
        operand.toIntOrNull() ?: throw IllegalArgumentException("$operand 는 피연산자가 될 수 없습니다.")
    )

    fun toDouble() = value.toDouble()

    override fun toString(): String = "${this.value}"

    fun addLastLetter(operand: Operand): Operand {
        val tens = this.value * PLACE_VALUE
        val units = operand.value
        return Operand(tens + units)
    }

    fun removeLastLetter(): Operand? {
        val removeUnitsValue = this.value / PLACE_VALUE
        if (removeUnitsValue < 1) return null
        return Operand(removeUnitsValue)
    }

    companion object {
        private const val PLACE_VALUE = 10
    }
}
