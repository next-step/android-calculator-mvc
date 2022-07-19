package edu.nextstep.camp.calculator.domain

import java.math.BigDecimal

enum class Operator(
    val operator: String,
    val calculate: (BigDecimal, BigDecimal) -> BigDecimal
) {

    PLUS("+", { currentOperand, nextOperand ->
        currentOperand + nextOperand
    }),
    MINUS("-", { currentOperand, nextOperand ->
        currentOperand - nextOperand
    }),
    MULTIPLE("*", { currentOperand, nextOperand ->
        currentOperand * nextOperand
    }),
    DIVIDE("/", { currentOperand, nextOperand ->
        try {
            currentOperand / nextOperand
        } catch (e: kotlin.ArithmeticException) {
            BigDecimal(0)
        }
    });

    companion object {
        fun find(input: String): Operator? = values().find { operator: Operator ->
            operator.operator == input
        }
    }

}