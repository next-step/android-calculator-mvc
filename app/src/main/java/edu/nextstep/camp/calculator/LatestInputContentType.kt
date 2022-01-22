package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator

enum class LatestInputContentType {
    NONE,
    NUMBER,
    OPERATOR;

    companion object {
        const val LENGTH_NUMBER_CONTENT = 1
        const val LENGTH_OPERATOR_CONTENT = 3

        fun getLatestInputContentType(contents: String): LatestInputContentType {
            if (contents.isEmpty()) {
                return NONE
            }

            val splitContents = contents.split(" ")
                .filter {
                    it.isNotEmpty()
                }

            val latestInput = splitContents.last()

            if (Calculator.isNumber(latestInput)) {
                return NUMBER
            }

            return OPERATOR
        }

        fun getLatestInputContentLength(contents: String): Int {
            return when (getLatestInputContentType(contents)) {
                NONE -> 0
                NUMBER -> LENGTH_NUMBER_CONTENT
                OPERATOR -> LENGTH_OPERATOR_CONTENT
            }
        }
    }
}
