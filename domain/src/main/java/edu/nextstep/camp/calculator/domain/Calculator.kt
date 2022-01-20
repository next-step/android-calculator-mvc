package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.ArithmeticOperator.Companion.calculate

object Calculator {
    fun calculateContents(contents: String): Double {
        if (contents.isEmpty()) {
            throw IllegalArgumentException()
        }

        val singleOperationContentArray = Array(SIZE_SINGLE_OPERATION_ARRAY) { "" }

        contents.split(" ")
            .forEach { content ->
                manageOperationContent(singleOperationContentArray, content)
            }

        return singleOperationContentArray[INDEX_NUMBER_FIRST].toDouble()
    }

    private fun manageOperationContent(contentArray: Array<String>, content: String) {
        when {
            contentArray[INDEX_NUMBER_FIRST].isEmpty() -> contentArray[INDEX_NUMBER_FIRST] = content
            contentArray[INDEX_OPERATOR].isEmpty() -> contentArray[INDEX_OPERATOR] = content
            contentArray[INDEX_NUMBER_SECOND].isEmpty() -> {
                contentArray[INDEX_NUMBER_SECOND] = content

                val arithmeticOperator = ArithmeticOperator.convertToArithmeticOperation(contentArray[INDEX_OPERATOR])
                contentArray[INDEX_NUMBER_FIRST] = arithmeticOperator.calculate(
                    contentArray[INDEX_NUMBER_FIRST].toDouble(),
                    contentArray[INDEX_NUMBER_SECOND].toDouble()
                ).toString()

                clearContentArrayExceptFirstNumber(contentArray)
            }
        }
    }

    private fun clearContentArrayExceptFirstNumber(contentArray: Array<String>) {
        contentArray[INDEX_NUMBER_SECOND] = ""
        contentArray[INDEX_OPERATOR] = ""
    }

    private const val INDEX_NUMBER_FIRST = 0
    private const val INDEX_OPERATOR = 1
    private const val INDEX_NUMBER_SECOND = 2
    private const val SIZE_SINGLE_OPERATION_ARRAY = 3
}
