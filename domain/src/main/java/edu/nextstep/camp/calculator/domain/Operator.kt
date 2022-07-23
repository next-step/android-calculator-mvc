package edu.nextstep.camp.calculator.domain

import java.lang.IllegalArgumentException

enum class Operator(
    val symbol: String,
    val operatorBlock: (oldValue: Double, newValue: Double) -> Double
) : Operational {
    SUM(symbol = "+", operatorBlock = { oldValue, newValue -> oldValue + newValue }),
    MINUS(symbol = "-", operatorBlock = { oldValue, newValue -> oldValue - newValue }),
    DIVIDE(symbol = "÷", operatorBlock = { oldValue, newValue -> oldValue / newValue }),
    MULTIPLY(symbol = "×", operatorBlock = { oldValue, newValue -> oldValue * newValue });

    fun execute(oldValue: Double, newValue: Double): Double =
        operatorBlock.invoke(oldValue, newValue)

    override fun isOperand(): Boolean = false

    override fun isRemoveAble(): Boolean = true

    override fun toString(): String = symbol

    companion object {
        const val OPERATOR_MUST_PREFIXED: String = "미리 정해지지 않은 연산자 입니다."

        fun findBySymbol(symbol: String): Operator =
            values().find { it.symbol == symbol } ?: throw IllegalArgumentException(
                "Operator : $symbol  $OPERATOR_MUST_PREFIXED"
            )

        fun isThisOperator(c: Char): Boolean {
            val symbol = c.toString()
            return values().find { it.symbol == symbol } != null
        }
    }
}