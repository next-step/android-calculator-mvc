package edu.nextstep.camp.calculator.domain

object StringCalculator {

    private const val OPERATOR_INDEX_UNIT = 2
    private const val OPERATOR_INDEX_BUFFER = 1

    fun calculate(expression: StringExpressionState): Operand {
        val (rawOperands, rawOperators) = expression.value
            .withIndex()
            .partition { it.index % OPERATOR_INDEX_UNIT == 0 }
        val operands = parseOperands(rawOperands)
        val operators = parseOperators(rawOperators)
        require(operands.size - OPERATOR_INDEX_BUFFER == operators.size) {
            "완전하지 않은 수식($expression)이 입력되었습니다."
        }
        return operands.reduceIndexed { index, first, second ->
            operators[index - OPERATOR_INDEX_BUFFER].action(first, second)
        }
    }

    fun calculate(raw: String): Operand =
        calculate(StringExpressionState.of(raw))

    private fun parseOperands(rawOperands: List<IndexedValue<Term>>): List<Operand> =
        rawOperands.mapNotNull { it.value as? Operand }

    private fun parseOperators(rawOperators: List<IndexedValue<Term>>): List<Operator> =
        rawOperators.mapNotNull { it.value as? Operator }

}
