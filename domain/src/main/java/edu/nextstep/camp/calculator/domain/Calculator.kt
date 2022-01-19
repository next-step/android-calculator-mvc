package edu.nextstep.camp.calculator.domain

object Calculator {
    fun calculateContents(contents: String): Double {
        if (contents.isEmpty()) {
            throw IllegalArgumentException()
        }

        val singleOperation = SingleOperation()

        contents.split(" ")
            .forEach { content ->
                manageContent(content, singleOperation)
            }

        return singleOperation.latestResult
    }

    private fun manageContent(content: String, singleOperationModel: SingleOperation) {
        singleOperationModel.addOperationContent(content)

        if (singleOperationModel.isCalculationOrder()) {
            val result = singleOperationModel.calculate()
            singleOperationModel.addOperationContent(result.toString())
        }
    }
}
