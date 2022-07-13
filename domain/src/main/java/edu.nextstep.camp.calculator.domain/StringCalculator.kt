package edu.nextstep.camp.calculator.domain

object StringCalculator {

    private const val SPLIT_DELIMITER = " "
    private const val OPERATOR_INDEX_UNIT = 2
    private const val OPERATOR_INDEX_BUFFER = 1

    fun calculate(raw: String): Number {
        val params = raw.split(SPLIT_DELIMITER)
        val (rawOperands, rawOperators) = params
            .withIndex()
            .partition { it.index % OPERATOR_INDEX_UNIT == 0 }
        val operands = rawOperands.map { Number.of(it.value) }
        val operators = rawOperators.map { Operation.of(it.value) }

        return operands.reduceIndexed { index, first, second ->
            operators[index - OPERATOR_INDEX_BUFFER].run(first, second)
        }
    }

}
