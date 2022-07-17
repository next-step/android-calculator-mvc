package edu.nextstep.camp.calculator.domain

@JvmInline
value class StringExpression(val value: String) {

    fun plusElement(operand: Operand): StringExpression {
        val shouldAddSpace = value.isNotEmpty() && !value.last().isDigit()
        val element = if (shouldAddSpace) {
            operand.value
                .toInt()
                .toString()
                .withSpacePrefix()
        } else {
            operand.value
                .toInt()
        }
        return StringExpression(value + element)
    }

    fun plusElement(operator: Operator): StringExpression = StringExpression(
        if (value.isEmpty()) {
            value
        } else {
            value + operator.symbol.withSpacePrefix()
        }
    )

    fun minusElement(): StringExpression = StringExpression(
        if (value.isEmpty()) {
            value
        } else {
            value.dropLast(CHARACTER_DELETE_UNIT).trim()
        }
    )

    private fun String.withSpacePrefix() = "$SPACE$this"

    companion object {
        private const val SPACE = " "
        private const val CHARACTER_DELETE_UNIT = 1
    }
}
