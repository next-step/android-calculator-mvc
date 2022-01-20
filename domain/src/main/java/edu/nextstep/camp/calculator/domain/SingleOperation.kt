package edu.nextstep.camp.calculator.domain

object SingleOperation {

    fun calculate(firstNumber: Double, secondNumber: Double, operator: ArithmeticOperation): Double {
        return when (operator) {
            ArithmeticOperation.PLUS -> firstNumber + secondNumber
            ArithmeticOperation.MINUS -> firstNumber - secondNumber
            ArithmeticOperation.MULTIPLICATION -> firstNumber * secondNumber
            ArithmeticOperation.DIVISION -> firstNumber / secondNumber
        }
    }
}
