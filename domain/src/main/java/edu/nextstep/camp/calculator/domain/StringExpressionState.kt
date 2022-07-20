package edu.nextstep.camp.calculator.domain

sealed interface StringExpressionState {

    val value: Terms

    fun addElement(operand: Operand): StringExpressionState

    fun addElement(operator: Operator): StringExpressionState

    fun removeElement(): StringExpressionState

    class EmptyState(override val value: Terms = Terms(emptyList())) : StringExpressionState {
        override fun addElement(operand: Operand): OperandLastState =
            OperandLastState(value + operand)

        override fun addElement(operator: Operator): EmptyState = this

        override fun removeElement(): StringExpressionState = this

        override fun toString(): String = ""
    }

    sealed class NotEmptyState : StringExpressionState {

        override fun addElement(operator: Operator): OperatorLastState =
            OperatorLastState(value + operator)

        override fun toString(): String = value.toString()
    }

    class OperandLastState(override val value: Terms) : NotEmptyState() {
        override fun addElement(operand: Operand): OperandLastState {
            val lastOperand = value.last() as Operand
            val newOperand = Operand(concatInt(lastOperand.value.toInt(), operand.value.toInt()))
            return of(value.dropLast() + newOperand) as OperandLastState
        }

        override fun removeElement(): StringExpressionState {
            val lastOperand = value.last() as Operand
            if (lastOperand.value < LAST_DIGIT_HANDLE_UNIT) return of(value.dropLast())
            val newOperand = dropLastDigit(lastOperand)
            return of(value.dropLast() + newOperand)
        }

        private fun dropLastDigit(operand: Operand) =
            Operand(operand.value / LAST_DIGIT_HANDLE_UNIT)

        private fun concatInt(first: Int, second: Int) = "$first$second".toInt()

        companion object {
            private const val LAST_DIGIT_HANDLE_UNIT = 10
        }
    }

    class OperatorLastState(override val value: Terms) : NotEmptyState() {
        override fun addElement(operand: Operand): OperandLastState =
            OperandLastState(value + operand)

        override fun removeElement(): StringExpressionState = of(value.dropLast())
    }

    companion object {
        fun of(expression: String): StringExpressionState {
            if (expression.isEmpty()) return EmptyState()
            return of(Terms.of(expression))
        }

        fun of(terms: List<Term>): StringExpressionState = of(Terms(terms))

        private fun of(terms: Terms): StringExpressionState = terms.toState()
    }
}
