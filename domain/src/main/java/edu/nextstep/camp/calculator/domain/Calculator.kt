package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluate(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(IS_NULL_OR_BLANK)
        }
        
        return 0
    }

    companion object {
        private const val IS_NULL_OR_BLANK = "Input is Null or Blank."
    }
}