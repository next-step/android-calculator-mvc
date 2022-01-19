package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.ArithmeticOperation.Companion.convertToArithmeticOperation

object Calculator {
    fun calculateContents(contents: String): Double {
        if (contents.isEmpty()) {
            throw IllegalArgumentException()
        }

        val singleOperationModel = SingleOperation()

        contents.split(" ")
            .forEach { content ->
                classifyContent(content, singleOperationModel)
            }

        return singleOperationModel.firstNumber
    }

    private fun classifyContent(content: String, singleOperation: SingleOperation) {
        when (singleOperation.currentCalculateOrder) {
            CalculateOrder.NUMBER_FIRST -> {
                singleOperation.firstNumber = content.toDouble()
            }
            CalculateOrder.OPERATION -> {
                singleOperation.operation = convertToArithmeticOperation(content)
            }
            CalculateOrder.NUMBER_SECOND -> {
                singleOperation.secondNumber = content.toDouble()
                singleOperation.firstNumber = singleOperation.calculate()
            }
        }
        singleOperation.changeToNextCalculateOrder()
    }
}
