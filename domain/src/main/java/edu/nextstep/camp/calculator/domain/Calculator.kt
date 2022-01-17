package edu.nextstep.camp.calculator.domain

class Calculator {
    private var _contents = ""
    val contents: String get() = _contents

    private var firstNumber: Double = 0.0
    private var operation: String = ""
    private var secondNumber: Double = 0.0
    private var currentCalculateOrder = CalculateOrder.NUMBER_FIRST

    fun initCalculator() {
        _contents = ""
        firstNumber = 0.0
        operation = ""
        secondNumber = 0.0
        currentCalculateOrder = CalculateOrder.NUMBER_FIRST
    }

    fun setCalculatorContents(contents: String) {
        _contents = contents
    }

    fun appendNumber(number: Int) {
        _contents.plus(number.toString())
    }

    fun calculateContents(): Double = try {
        _contents.split(" ")
            .forEach { content ->
                executeCurrentCalculateOrder(content)
            }

        firstNumber
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }

    private fun executeCurrentCalculateOrder(content: String) {
        when (currentCalculateOrder) {
            CalculateOrder.NUMBER_FIRST -> {
                firstNumber = content.toDouble()
                changeToNextCalculateOrder()
            }
            CalculateOrder.OPERATION -> {
                operation = content
                changeToNextCalculateOrder()
            }
            CalculateOrder.NUMBER_SECOND -> {
                secondNumber = content.toDouble()
                executeSingleOperation()
                changeToNextCalculateOrder()
            }
        }
    }

    private fun changeToNextCalculateOrder() {
        currentCalculateOrder = when (currentCalculateOrder) {
            CalculateOrder.NUMBER_FIRST -> CalculateOrder.OPERATION
            CalculateOrder.OPERATION -> CalculateOrder.NUMBER_SECOND
            CalculateOrder.NUMBER_SECOND -> CalculateOrder.OPERATION
        }
    }

    private fun executeSingleOperation() {
        when (operation) {
            "+" -> {
                firstNumber += secondNumber
                return
            }
            "-" -> {
                firstNumber -= secondNumber
                return
            }
            "*" -> {
                firstNumber *= secondNumber
                return
            }
            "/" -> {
                firstNumber /= secondNumber
                return
            }
        }

        throw IllegalArgumentException()
    }

    private enum class CalculateOrder {
        NUMBER_FIRST,
        NUMBER_SECOND,
        OPERATION
    }
}
