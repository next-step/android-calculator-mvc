package com.nextstep.domain

class StringCalculator {
    companion object {
        private const val ERROR_MESSAGE_ARGUMENT_NULL_OR_EMPTY = "입력 받은 파라메터가 NULL 또는 빈 값입니다."

        private const val FORMULA_SPLIT_DELIMITER = " "
    }

    fun calculate(formula: String): Double {
        validateNullOrEmpty(formula)
        val splitFormulas = formula.split(FORMULA_SPLIT_DELIMITER)

        var leftNum: Double? = null
        var rightNum: Double? = null

        for(i:Int in 1 until splitFormulas.size step(2)) {
            if(leftNum == null) {
                leftNum = splitFormulas[i-1].toDouble()
            }
            rightNum = splitFormulas[i+1].toDouble()
            leftNum = Operator.fromSymbol(splitFormulas[i]).calculate(leftNum, rightNum)
        }
        return leftNum ?: 0.0
    }

    private fun validateNullOrEmpty(formula: String) {
        if(formula.isEmpty()) {
            throw IllegalArgumentException(ERROR_MESSAGE_ARGUMENT_NULL_OR_EMPTY)
        }
    }
}