package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator

enum class LatestInputContentType {
    NONE,
    OPERAND,
    SIGN;

    companion object {
        const val LENGTH_OPERAND_CONTENT = 1
        const val LENGTH_SIGN_CONTENT = 3

        fun getLatestInputContentType(formula: String): LatestInputContentType {
            if (formula.isEmpty()) {
                return NONE
            }

            val splitFormula = formula.split(" ")
                .filter {
                    it.isNotEmpty()
                }

            val latestInput = splitFormula.last()

            if (Calculator.isNumber(latestInput)) {
                return OPERAND
            }

            return SIGN
        }

        fun getLatestInputContentLength(formula: String): Int {
            return when (getLatestInputContentType(formula)) {
                NONE -> 0
                OPERAND -> LENGTH_OPERAND_CONTENT
                SIGN -> LENGTH_SIGN_CONTENT
            }
        }
    }
}
