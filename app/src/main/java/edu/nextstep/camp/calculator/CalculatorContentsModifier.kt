package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator

object CalculatorContentsModifier {

    fun appendNumber(contents: String, number: String): String {
        return contents + number
    }

    fun appendOperator(contents: String, operator: String): String {

        var result = contents

        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contents)
        if (latestInputContentType == LatestInputContentType.NONE) {
            return result
        }

        if (latestInputContentType == LatestInputContentType.OPERATOR) {
            result = LatestInputContentType.removeLatestInputContent(contents)
        }

        return "$result $operator "
    }

    fun removeLatest(contents: String): String {
        return LatestInputContentType.removeLatestInputContent(contents)
    }

    fun calculateContents(contents: String): String {
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contents)
        if (latestInputContentType != LatestInputContentType.NUMBER) {
            throw IllegalArgumentException()
        }

        val result = Calculator.calculateContents(contents)

        return if (Calculator.isRoundedNumber(result)) {
            result.toInt()
                .toString()
        } else {
            result.toString()
        }
    }
}
