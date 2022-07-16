package edu.nextstep.camp.calculator.domain

object StringCalculator {

    private const val SPLIT_DELIMITER = " "
    private const val OPERATOR_INDEX_UNIT = 2
    private const val OPERATOR_INDEX_BUFFER = 1

    fun calculate(raw: String): Operand {
        val (rawOperands, rawOperators) = splitParams(raw)
            .withIndex()
            .partition { it.index % OPERATOR_INDEX_UNIT == 0 }
        val operands = parseOperands(rawOperands)
        val operators = parseOperators(rawOperators)
        require(operands.size - OPERATOR_INDEX_BUFFER == operators.size) {
            "완전하지 않은 수식이 입력되었습니다."
        }

        return operands.reduceIndexed { index, first, second ->
            operators[index - OPERATOR_INDEX_BUFFER].action(first, second)
        }
    }

    private fun splitParams(raw: String): List<String> = raw.split(SPLIT_DELIMITER)

    private fun parseOperands(rawOperands: List<IndexedValue<String>>): List<Operand> =
        rawOperands.map { Operand.of(it.value) }

    private fun parseOperators(rawOperators: List<IndexedValue<String>>): List<Operator> =
        rawOperators.map { Operator.of(it.value) }

}
