package edu.nextstep.camp.calculator.domain

@JvmInline
value class Terms(private val value: List<Term>) {

    operator fun plus(term: Term): Terms = Terms(value + term)

    fun toState(): StringExpressionState = when {
        value.isEmpty() -> StringExpressionState.EmptyState()
        value.last() is Operand -> StringExpressionState.OperandLastState(this)
        else -> StringExpressionState.OperatorLastState(this)
    }

    fun last() = value.last()

    fun dropLast() = value.dropLast(CHARACTER_DELETE_UNIT)

    fun withIndex(): Iterable<IndexedValue<Term>> = value.withIndex()

    override fun toString(): String =
        value.joinToString(SPACE) {
            when (it) {
                is Operand -> it.value.toInt().toString()
                is Operator -> it.symbol
                else -> it.toString()
            }
        }

    companion object {
        private const val SPACE = " "
        private const val CHARACTER_DELETE_UNIT = 1
        private const val OPERATOR_INDEX_UNIT = 2

        fun of(expression: String): Terms = Terms(
            expression
                .split(SPACE)
                .mapIndexed { index, rawTerm ->
                    if (index % OPERATOR_INDEX_UNIT == 0) Operand.of(rawTerm) else Operator.of(
                        rawTerm
                    )
                }
        )
    }
}
