package com.example.domain

class Calculator {

    fun evaluate(input: String?): Int {
        var values = checkInputNullOrBlank(input)
        values = values.replace(" ", "")
        checkInputLength(values)
        checkInputFirstLetter(values)

        var result = values[0].digitToInt()
        for (i in 1..values.lastIndex step 2) {
            val operator = Operator.find(values[i])
            val secondOperand = values[i + 1].digitToInt()
            result = operator.calculateStrategy(result, secondOperand)
        }
        return result
    }

    private fun checkInputNullOrBlank(input: String?): String {
        if (input.isNullOrBlank()) throw IllegalArgumentException(IS_NOT_NULL_OR_BLANK)
        return input
    }

    private fun checkInputLength(input: String) {
        require(input.length > 2) {
            throw IllegalArgumentException(IS_NOT_MATH_EXPRESSION)
        }

    }

    private fun checkInputFirstLetter(input: String) {
        require(input[0].isDigit()) {
            throw IllegalArgumentException(IS_NOT_MATH_EXPRESSION)
        }

    }


    companion object {
        const val IS_NOT_NULL_OR_BLANK = "입력값이 NULL 이거나 공백일 수 없습니다"
        const val IS_NOT_MATH_EXPRESSION = "입력값이 제대로 된 수식이 아닙니다."
    }
}