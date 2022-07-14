package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluate(input: String?): Int {
        require(!input.isNullOrBlank()) { IllegalArgumentException(IS_NULL_OR_BLANK) }

        val inputList = Splitter.splitByDelimiter(input)
        require(inputList.size % EVEN_COMPARISON_NUMBER == RESULT_WHEN_ODD_NUMBER) {
            IllegalArgumentException(NOT_MATCH_OPERATORS_AND_OPERANDS)
        }

        // 첫숫자는 바로 계산하기 위해 저장한다.
        var output = Operand.of(inputList.first())
        for (index in NUMBER_OF_EXCLUDING_THE_FIRST_INDEX until inputList.size step SIZE_OF_CALCULATION_UNIT) {
            output =
                Operator.of(inputList[index])
                    .calculate(output, Operand.of(inputList[index + INDEX_OF_NUMBER]))
        }

        return output.value
    }


    companion object {
        private const val EVEN_COMPARISON_NUMBER = 2
        private const val RESULT_WHEN_ODD_NUMBER = 1

        private const val NUMBER_OF_EXCLUDING_THE_FIRST_INDEX = 1
        private const val SIZE_OF_CALCULATION_UNIT = 2

        private const val INDEX_OF_NUMBER = 1

        private const val IS_NULL_OR_BLANK = "인풋이 null이거나 blank입니다."
        private const val NOT_MATCH_OPERATORS_AND_OPERANDS = "연산자와 피연산자 갯수가 맞지 않습니다."
    }
}