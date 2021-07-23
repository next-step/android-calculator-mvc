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
            if (firstOperand == 0.0 || secondOperand == 0.0) {
                throw ArithmeticException("divide not zero")
            }
            firstOperand / secondOperand
        }
    );

    companion object {

        fun findBySymbol(symbol: Char): Operator = values()
            .firstOrNull {
                it.symbol == symbol
            }
            ?: throw IllegalArgumentException("invalid symbol")
    }
}
