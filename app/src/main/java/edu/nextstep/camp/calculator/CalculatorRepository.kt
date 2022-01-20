package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator

class CalculatorRepository {
    private val contentList = mutableListOf<String>()

    fun appendNumberContent(content: String) {
        contentList.add(content)
    }

    fun appendOperatorContent(content: String) {
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contentList)
        if (latestInputContentType == LatestInputContentType.NONE) {
            return
        }

        if (latestInputContentType == LatestInputContentType.OPERATOR) {
            contentList.removeLast()
        }

        contentList.add(" $content ")
    }

    fun deleteAllContent() {
        contentList.clear()
    }

    fun deleteLatestContent() {
        if (contentList.isEmpty()) {
            return
        }

        contentList.removeLast()
    }

    fun calculateContents(): Double {
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contentList)
        if (latestInputContentType != LatestInputContentType.NUMBER) {
            throw IllegalArgumentException()
        }

        val result = Calculator.calculateContents(buildStringFromContentsList())
        contentList.clear()

        if (Calculator.isRoundedNumber(result)) {
            contentList.add(result.toInt()
                .toString())
        } else {
            contentList.add(result.toString())
        }
        return result
    }

    fun getDisplayContents(): String {
        return buildStringFromContentsList()
    }

    private fun buildStringFromContentsList(): String {
        val displayContentsBuilder = StringBuilder()

        contentList.forEach {
            displayContentsBuilder.append(it)
        }

        return displayContentsBuilder.toString()
    }
}
