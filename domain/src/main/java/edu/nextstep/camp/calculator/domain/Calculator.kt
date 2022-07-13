package edu.nextstep.camp.calculator.domain

class Calculator {
    @Throws(IllegalArgumentException::class)
    fun evalute(text: String?): Int {
        assertValidText(text)
        return text!!.let {
            compute(getNumbers(it), getOperators(it))
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun assertValidText(text: String?) = when {
        text.isNullOrBlank() -> throw IllegalArgumentException("wrong text input : $text")
        else -> {}
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
            .split("[0-9]".toRegex())
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
