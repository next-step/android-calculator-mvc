package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator

object CalculatorFormulaModifier {

    fun appendOperand(formula: String, operand: String): String {
        return formula + operand
    }

    fun appendOperator(formula: String, operator: String): String {

        var result = formula

        val latestInputContentType = LatestInputContentType.getLatestInputContentType(formula)
        if (latestInputContentType == LatestInputContentType.NONE) {
            return result
        }

        if (latestInputContentType == LatestInputContentType.OPERATOR) {
            result = removeLatest(formula)
        }

        return "$result $operator "
    }

    fun removeLatest(formula: String): String {
        val latestContentLength = LatestInputContentType.getLatestInputContentLength(formula)

        return formula.substring(0 until formula.length - latestContentLength)
    }

    fun calculateFormula(formula: String): String {
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(formula)
        if (latestInputContentType != LatestInputContentType.OPERAND) {
            throw IllegalArgumentException()
        }

        val result = Calculator.calculateFormula(formula)

        return if (Calculator.isRoundedNumber(result)) {
            result.toInt()
                .toString()
        } else {
            result.toString()
        }
    }
}
