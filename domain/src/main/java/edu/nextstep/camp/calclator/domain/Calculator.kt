package edu.nextstep.camp.calclator.domain

class Calculator {

    @Throws(IllegalArgumentException::class)
    fun evalute(text: String?) : Int {
        assertText(text)
        return compute(getNumbers(text!!), getOperators(text))
    }

    @Throws(IllegalArgumentException::class)
    private fun assertText(text: String?) =
         when {
            text.isNullOrBlank() -> throw IllegalArgumentException("wrong text, input : $text")
            else -> {}
        }

    private fun compute(numbers: List<Int>, operators: List<String>): Int {
        return numbers.reduceIndexed { index, left, right ->
            when (operators[index - 1]) {
                "+" -> left + right
                "-" -> left - right
                "*" -> left * right
                "/" -> left / right
                else -> throw IllegalArgumentException("wrong operator : ${operators[index]}")
            }
        }
    }

    private fun getOperators(text: String): List<String> {
        return text.split("[0-9]".toRegex())
            .filter { it.isNotBlank() }
            .map { it.trim().last().toString() }

    }

    private fun getNumbers(text: String): List<Int> {
        return text
            .replace(" ", "")
            .split('+', '-', '*', '/')
            .filter { it.isNotBlank() }
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("wrong operator included.") }
    }
}