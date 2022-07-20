package edu.nextstep.camp.calculator.domain.camp.calculator

import edu.nextstep.camp.calculator.domain.camp.calculator.Operation.Companion.getOperators

class Calculator {

    @Throws(IllegalArgumentException::class)
    fun evaluate(inputValueStr: String?) : Double {
        require(!inputValueStr.isNullOrBlank()) { "잘못된 요청입니다. : $inputValueStr" }
        return compute(getNumbers(inputValueStr), getOperators(inputValueStr))
    }

    @Throws(IllegalArgumentException::class)
    private fun compute(numbers: List<Double>, operators: List<Char>) : Double {
        require(operators.size == numbers.size - 1) { "완성되지 않은 수식입니다." }
        return numbers.reduceIndexed { index, left, right ->
            val operator = Operation.get(operators[index - 1])
            operator(left, right)
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun getNumbers(inputValueStr: String) : List<Double> {
        return inputValueStr
            .replace(" ", "")
            .split(*Operation.getChars())
            .filter { it.isNotBlank() }
            .map { it.trim().toDoubleOrNull() ?: throw IllegalArgumentException("잘못된 연산자가 포함되었습니다.") }
    }
}