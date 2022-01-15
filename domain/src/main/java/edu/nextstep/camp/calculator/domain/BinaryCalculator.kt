package edu.nextstep.camp.calculator.domain

typealias Operator = (Int, Int) -> Int
typealias Operand = Int

internal class BinaryCalculator(private val operator: Operator, private val operand2: Operand) {

    fun evaluate(operand1: Operand) = operator.invoke(operand1, operand2)

    companion object {

        fun of(chunks: Chunks): BinaryCalculator {
            val (token, digit) = chunks
            val operator = operatorBy(token)

            return BinaryCalculator(operator = operator, operand2 = digit.toInt())
        }

        private fun operatorBy(token: String): Operator = when (token) {
            "+" -> { x, y -> x + y }
            "-" -> { x, y -> x - y }
            "*" -> { x, y -> x * y }
            "/" -> { x, y -> x / y }
            else -> throw IllegalArgumentException()
        }
    }
}