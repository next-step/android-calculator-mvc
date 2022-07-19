package edu.nextstep.camp.calculator.domain.camp.calculator

import edu.nextstep.camp.calculator.domain.camp.calculator.Operation.Companion.getOperators

class Calculator {

    @Throws(IllegalArgumentException::class)
    fun evaluate(inputValueStr: String?) : Int {

        requireNotNull(inputValueStr) { "wrong inputValueStr : $inputValueStr" }
        require(inputValueStr.isNotBlank()) { "wrong inputValueStr : $inputValueStr" }

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

    @Throws(IllegalArgumentException::class)
    private fun getNumbers(text: String): List<Int> {
        return text
            .replace(" ", "")
            .split(*Operation.getChars())
            .filter { it.isNotBlank() }
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("wrong operator included.") }
    }
}