package edu.nextstep.camp.calculator

enum class Operator(
    val symbol: Char,
    val formula: (firstOperand: Double, secondOperand: Double) -> Double
) {
    PLUS(
        symbol = '+',
        formula = { firstOperand, secondOperand ->
            firstOperand + secondOperand
        }
    ),
    MINUS(
        symbol = '-',
        formula = { firstOperand, secondOperand ->
            firstOperand - secondOperand
        }
    ),
    MULTIPLE(
        symbol = '*',
        formula = { firstOperand, secondOperand ->
            firstOperand * secondOperand
        }
    ),
    DIVIDE(
        symbol = '/',
        formula = { firstOperand, secondOperand ->
            firstOperand / secondOperand
        }
    )
}
