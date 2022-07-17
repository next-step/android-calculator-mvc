package edu.nextstep.camp.calculator.domain.camp.calculator

class Calculator {
    private companion object {
        val OPERATOR_SPLIT_REGEX = "[0-9]".toRegex()
    }

    @Throws(IllegalArgumentException::class)
    fun evaluate(inputValueStr: String?) : Int {

        // Null 체크
        requireNotNull(inputValueStr) {
            "wrong inputValueStr : $inputValueStr"
        }

        // 빈 값인지 체크
        require(inputValueStr.isNotBlank()) {
            "wrong inputValueStr : $inputValueStr"
        }

        return compute(getNumbers(inputValueStr), getOperators(inputValueStr))
    }

    @Throws(IllegalArgumentException::class)
    private fun compute(numbers: List<Int>, operators: List<Char>) : Int {
        val returnNumber = numbers.reduceIndexed { index, left, right ->
            val operator = Operation.get(operators[index - 1])
            operator(left, right)
        }
        return returnNumber
    }

    private fun getOperators(inputValueStr: String) : List<Char> {
        val refinedValueList = inputValueStr
            .split(OPERATOR_SPLIT_REGEX)
            .filter { it.isNotBlank() }
            .map { it.trim().last() }
        return refinedValueList
    }

    @Throws(IllegalArgumentException::class)
    private fun getNumbers(text: String): List<Int> {
        return text
            .replace(" ", "")
            .split(*Operation.getChars())
            .filter { it.isNotBlank() }
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("wrong operator included.") }
    }
}