package edu.nextstep.camp.calculator.domain

import java.lang.IllegalArgumentException

enum class Operator(
    val symbol: String,
    val operatorBlock: (oldValue: Double, newValue: Double) -> Double
) {
    SUM(symbol = "+", operatorBlock = { oldValue, newValue -> oldValue + newValue }),
    MINUS(symbol = "-", operatorBlock = { oldValue, newValue -> oldValue - newValue }),
    DIVIDE(symbol = "/", operatorBlock = { oldValue, newValue -> oldValue / newValue }),
    MULTIPLY(symbol = "*", operatorBlock = { oldValue, newValue -> oldValue * newValue });

    fun execute(oldValue: Double, newValue: Double) = operatorBlock.invoke(oldValue, newValue)

    companion object {
        fun findBySymbol(symbol: String): Operator =
            values().find { it.symbol == symbol } ?: throw IllegalArgumentException()
    }
}