package edu.nextstep.camp.calculator.domain

class SingleOperation {
    private var _firstNumber: Double = 0.0
    private var _secondNumber: Double = 0.0
    private var _operation: ArithmeticOperation = ArithmeticOperation.PLUS
    private var _currentCalculateOrder: CalculateOrder = CalculateOrder.NUMBER_FIRST

    private var _latestResult: Double = 0.0
    val latestResult: Double get() = _latestResult

    fun addOperationContent(content: String) {
        when (_currentCalculateOrder) {
            CalculateOrder.NUMBER_FIRST -> _firstNumber = content.toDouble()
            CalculateOrder.OPERATION -> _operation = ArithmeticOperation.convertToArithmeticOperation(content)
            CalculateOrder.NUMBER_SECOND -> _secondNumber = content.toDouble()
            CalculateOrder.CALCULATION -> throw IllegalArgumentException()
        }
        changeToNextCalculateOrder()
    }

    fun calculate(): Double {
        if (!isCalculationOrder()) {
            throw IllegalArgumentException()
        }

        val result = when (_operation) {
            ArithmeticOperation.PLUS -> _firstNumber + _secondNumber
            ArithmeticOperation.MINUS -> _firstNumber - _secondNumber
            ArithmeticOperation.MULTIPLICATION -> _firstNumber * _secondNumber
            ArithmeticOperation.DIVISION -> _firstNumber / _secondNumber
        }
        _latestResult = result
        _currentCalculateOrder = CalculateOrder.NUMBER_FIRST
        return result
    }

    fun isCalculationOrder() = _currentCalculateOrder == CalculateOrder.CALCULATION

    private fun changeToNextCalculateOrder() {
        _currentCalculateOrder = _currentCalculateOrder.getNextCalculateOrder()
    }
}
