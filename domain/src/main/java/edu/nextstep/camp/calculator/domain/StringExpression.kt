package edu.nextstep.camp.calculator.domain

@JvmInline
value class StringExpression(val value: String) {

    fun plusElement(operand: Operand): StringExpression {
        val shouldAddSpace = value.isNotEmpty() && !value.last().isDigit()
        return StringExpression(
            value + if (shouldAddSpace) "$SPACE${operand.value.toInt()}" else operand.value.toInt()
        )
    }

    fun plusElement(operator: Operator): StringExpression = StringExpression(
        if (value.isEmpty()) {
            value
        } else {
            value + "$SPACE${operator.symbol}"
        }
    )

    fun minusElement(): StringExpression = StringExpression(
        if (value.isEmpty()) {
            value
        } else {
            value.dropLast(CHARACTER_DELETE_UNIT).trim()
        }
    )

    companion object {
        private const val SPACE = " "
        private const val CHARACTER_DELETE_UNIT = 1
    }
}
