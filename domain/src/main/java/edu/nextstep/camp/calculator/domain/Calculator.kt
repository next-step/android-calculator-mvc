package edu.nextstep.camp.calculator.domain

class Calculator {
    private companion object {
        val OPERATOR_SPLIT_REGEX = "[0-9\\.]".toRegex()
    }

    @Throws(IllegalArgumentException::class)
    fun evalute(text: String?): Double {
        require(!text.isNullOrBlank()) { "잘못된 요청입니다. : $text" }
        val arrangedRequest = getArrangedRequest(text)
        return compute(getNumbers(arrangedRequest), getOperators(arrangedRequest))
    }

    private fun getArrangedRequest(text: String) = if (text[0] == '-') {
        "0$text"
    } else {
        text
    }

    @Throws(IllegalArgumentException::class)
    private fun compute(numbers: List<Double>, operators: List<Char>): Double {
        require(operators.size == numbers.size-1) {"완성되지 않은 수식입니다."}
        return numbers.reduceIndexed { index, left, right ->
            val operator = Operator.get(operators[index - 1])
            operator(left, right)
        }
    }

    private fun getOperators(text: String): List<Char> {
        return text
            .split(OPERATOR_SPLIT_REGEX)
            .filter { it.isNotBlank() }
            .map { it.trim().also { trimmed -> if(trimmed.length > 1) throw IllegalArgumentException("잘못된 연산자가 포함되었습니다.")  }.last() }
    }

    @Throws(IllegalArgumentException::class)
    private fun getNumbers(text: String): List<Double> {
        return text
            .replace(" ", "")
            .split(*Operator.getChars())
            .filter { it.isNotBlank() }
            .map { it.trim().toDoubleOrNull() ?: throw IllegalArgumentException("잘못된 연산자가 포함되었습니다.") }
    }
}
