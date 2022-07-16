package edu.nextstep.camp.calculator.domain

object StringCalculator {

    private const val SPLIT_DELIMITER = " "
    private const val OPERATOR_INDEX_UNIT = 2
    private const val OPERATOR_INDEX_BUFFER = 1

    fun calculate(raw: String?): Operand {
        requireNotNull(raw)
        val (rawOperands, rawOperators) = splitParams(raw)
            .withIndex()
            .partition { it.index % OPERATOR_INDEX_UNIT == 0 }
        val operands = parseOperands(rawOperands)
        val operators = parseOperators(rawOperators)

        return operands.reduceIndexed { index, first, second ->
            operators[index - OPERATOR_INDEX_BUFFER].run(first, second)
        }
    }

    private fun splitParams(raw: String): List<String> = raw.split(SPLIT_DELIMITER)

    private fun parseOperands(rawOperands: List<IndexedValue<String>>): List<Operand> =
        rawOperands.map { Operand.of(it.value) }

    private fun parseOperators(rawOperators: List<IndexedValue<String>>): List<Operation> =
        rawOperators.map { Operation.of(it.value) }

}
