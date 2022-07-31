package camp.calculator

import java.lang.IllegalArgumentException

typealias Operator = (Int, Int) -> Int
typealias Operand = Int

internal class CalculateBinary private constructor(private val operator: Operator) {

    fun evaluate(operandFirst: Operand, operandSecond: Operand) = operator.invoke(operandFirst, operandSecond)

    companion object {

        fun of(token: String) = CalculateBinary(operatorBy(token))

        private fun operatorBy(token: String): Operator = when (token) {
            "+" -> { x, y -> x + y }
            "-" -> { x, y -> x - y }
            "*" -> { x, y -> x * y }
            "/" -> { x, y -> x / y }
            else -> throw IllegalArgumentException()
        }

    }

}