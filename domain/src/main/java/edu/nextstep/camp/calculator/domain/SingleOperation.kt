package edu.nextstep.camp.calculator.domain

data class SingleOperation(
    var firstNumber: Double = 0.0,
    var operation: ArithmeticOperation = ArithmeticOperation.PLUS,
    var secondNumber: Double = 0.0,
    var currentCalculateOrder: CalculateOrder = CalculateOrder.NUMBER_FIRST
) {
    fun calculate(): Double {
        return when (operation) {
            ArithmeticOperation.PLUS -> firstNumber + secondNumber
            ArithmeticOperation.MINUS -> firstNumber - secondNumber
            ArithmeticOperation.MULTIPLICATION -> firstNumber * secondNumber
            ArithmeticOperation.DIVISION -> firstNumber / secondNumber
        }
    }

    fun changeToNextCalculateOrder() {
        currentCalculateOrder = currentCalculateOrder.getNextCalculateOrder()
    }
}
