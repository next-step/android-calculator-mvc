package com.nextstep.domain

class StringCalculator {
    companion object {
        private const val ERROR_MESSAGE_ARGUMENT_NULL_OR_EMPTY = "입력 받은 파라메터가 NULL 또는 빈 값입니다."

        private const val FORMULA_SPLIT_DELIMITER = " "
    }

    fun calculate(formula: String): Double {
        validateNullOrEmpty(formula)
    }

    private fun validateNullOrEmpty(formula: String) {
        if(formula.isEmpty()) {
            throw IllegalArgumentException(ERROR_MESSAGE_ARGUMENT_NULL_OR_EMPTY)
        }
    }
}