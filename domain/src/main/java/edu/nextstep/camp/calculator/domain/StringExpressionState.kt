package edu.nextstep.camp.calculator.domain

private const val SPACE = " "
private fun String.withSpacePrefix() = "${SPACE}$this"

sealed interface StringExpressionState {

    val value: String

    fun plusElement(operand: Operand): StringExpressionState

    fun plusElement(operator: Operator): StringExpressionState

    fun minusElement(): StringExpressionState

    class EmptyState(override val value: String = "") : StringExpressionState {
        override fun plusElement(operand: Operand): OperandLastState =
            OperandLastState(value + operand.value.toInt())

        override fun plusElement(operator: Operator): EmptyState = this

        override fun minusElement(): StringExpressionState = this
    }

    sealed class NotEmptyState : StringExpressionState {

        override fun plusElement(operator: Operator): OperatorLastState =
            OperatorLastState(value + operator.symbol.withSpacePrefix())

        override fun minusElement(): StringExpressionState =
            StringExpressionState.of(value.dropLast(CHARACTER_DELETE_UNIT).trim())
    }

    class OperandLastState(override val value: String) : NotEmptyState() {
        override fun plusElement(operand: Operand): OperandLastState =
            OperandLastState(value + operand.value.toInt())
    }

    class OperatorLastState(override val value: String) : NotEmptyState() {
        override fun plusElement(operand: Operand): OperandLastState =
            OperandLastState(
                value + operand.value
                    .toInt()
                    .toString()
                    .withSpacePrefix()
            )
    }

    companion object {
        private const val CHARACTER_DELETE_UNIT = 1

        fun of(expression: String): StringExpressionState = when {
            expression.isEmpty() -> EmptyState()
            expression.last().isDigit() -> OperandLastState(expression)
            else -> OperatorLastState(expression)
        }
    }
}
