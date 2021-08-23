package edu.nextstep.camp.calculator.model

import kotlin.math.sign

enum class Operator(
    val sign: String,
    val formula: (firstOperand: Double, secondOperand: Double) -> Double
) {
    PLUS(
        sign = "+",
        formula = { firstOperand, secondOperand ->
            firstOperand + secondOperand
        }
    ),
    MINUS(
        sign = "-",
        formula = { firstOperand, secondOperand ->
            firstOperand - secondOperand
        }
    ),
    MULTIPLY(
        sign = "*",
        formula = { firstOperand, secondOperand ->
            firstOperand * secondOperand
        }
    ),
    DIVIDE(
        sign = "/",
        formula = { firstOperand, secondOperand ->
            if (secondOperand == 0.0) {
                throw ArithmeticException("Divide by zero should trow")
            }
            firstOperand / secondOperand
        }
    );

    companion object {
        fun of(sign: String): Operator? {
            return Operator.values().firstOrNull {
                it.sign == sign
            }
        }
    }
}