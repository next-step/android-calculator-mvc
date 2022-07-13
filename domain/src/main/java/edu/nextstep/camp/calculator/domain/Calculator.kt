package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluate(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(IS_NULL_OR_BLANK)
        }

        val inputList = splitByDelimiter(input)
        if (inputList.size % EVEN_COMPARISON_NUMBER == RESULT_WHEN_EVEN_NUMBER) {
            throw IllegalArgumentException(NOT_MATCH_OPERATORS_AND_OPERANDS)
        }

        // 첫숫자는 바로 계산하기 위해 저장한다.
        var output = changeStringToInt(inputList.first())
        for (index in NUMBER_OF_EXCLUDING_THE_FIRST_INDEX until inputList.size step SIZE_OF_CALCULATION_UNIT) {
            output =
                Operator.of(inputList[index])
                    .calculate(output, changeStringToInt(inputList[index + INDEX_OF_NUMBER]))
        }

        return output
    }

    /**
     * 문자열을 스페이스로 나눠 List로 돌려주는 메소드.
     */
    private fun splitByDelimiter(input: String): List<String> {
        return input.split(DELIMITER)
    }

    /**
     * 계산가능한 숫자인지 확인하는 메소드.
     */
    private fun changeStringToInt(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(IS_NON_DIGIT_CHARACTER)
    }

    companion object {
        private const val DELIMITER = " "

        private const val EVEN_COMPARISON_NUMBER = 2
        private const val RESULT_WHEN_EVEN_NUMBER = 0

        private const val NUMBER_OF_EXCLUDING_THE_FIRST_INDEX = 1
        private const val SIZE_OF_CALCULATION_UNIT = 2

        private const val INDEX_OF_NUMBER = 1

        private const val IS_NULL_OR_BLANK = "인풋이 null이거나 blank입니다."
        private const val NOT_MATCH_OPERATORS_AND_OPERANDS = "연산자와 피연산자 갯수가 맞지 않습니다."
        private const val IS_NON_DIGIT_CHARACTER = "숫자 위치에 숫자가 오지 않았습니다."
    }
}