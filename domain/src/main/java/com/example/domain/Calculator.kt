package com.example.domain

class Calculator {

    fun evaluate(input: String?): Int {
        var result = 0
        var mutableOperand = Operator.findOperator('+')

        val expression = checkInputString(input).also {
            checkInputLength(it)
            checkInputFirstLetter(it)
        }

        expression.forEach { value ->
            when (value.isDigit()) {
                true -> result = mutableOperand.operate(result, value.digitToInt())
                false -> mutableOperand = Operator.findOperator(value)
            }
        }
        return result
    }

    private fun checkInputString(input: String?): String {
        if (input.isNullOrBlank()) throw IllegalArgumentException(IS_NOT_NULL_OR_BLANK)
        return input.replace(" ", "")
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