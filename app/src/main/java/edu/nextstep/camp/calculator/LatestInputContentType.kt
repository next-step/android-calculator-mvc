package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator

enum class LatestInputContentType {
    NONE,
    NUMBER,
    OPERATOR;

    companion object {
        private const val LENGTH_NUMBER_CONTENT = 1
        private const val LENGTH_OPERATOR_CONTENT = 3

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

        fun removeLatestInputContent(contents: String): String {
            val latestInputLength = when (getLatestInputContentType(contents)) {
                NONE -> return contents
                NUMBER -> LENGTH_NUMBER_CONTENT
                OPERATOR -> LENGTH_OPERATOR_CONTENT
            }

            return contents.substring(0 until contents.length - latestInputLength)
        }
    }
}
