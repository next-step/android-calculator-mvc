package edu.nextstep.camp.calculator.domain

object SingleOperation {

    fun calculate(firstNumber: Double, secondNumber: Double, operator: ArithmeticOperator): Double {
        return when (operator) {
            ArithmeticOperator.PLUS -> firstNumber + secondNumber
            ArithmeticOperator.MINUS -> firstNumber - secondNumber
            ArithmeticOperator.MULTIPLICATION -> firstNumber * secondNumber
            ArithmeticOperator.DIVISION -> firstNumber / secondNumber
        }
    }
}
