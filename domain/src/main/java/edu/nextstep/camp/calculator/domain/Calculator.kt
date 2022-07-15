package edu.nextstep.camp.calculator.domain

class Calculator {
    private companion object {
        val OPERATOR_SPLIT_REGEX = "[0-9]".toRegex()
    }

    @Throws(IllegalArgumentException::class)
    fun evalute(text: String?): Int {
        requireNotNull(text) { "wrong text input : $text" }
        require(text.isNotBlank()) { "wrong text input : $text" }
        return compute(getNumbers(text), getOperators(text))
    }

    @Throws(IllegalArgumentException::class)
    private fun compute(numbers: List<Int>, operators: List<Char>): Int {
        return numbers.reduceIndexed { index, left, right ->
            val operator = Operation.get(operators[index - 1])
            operator(left, right)
        }
    }

    private fun getOperators(text: String): List<Char> {
        return text
            .split(OPERATOR_SPLIT_REGEX)
            .filter { it.isNotBlank() }
            .map { it.trim().last() }
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
