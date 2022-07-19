package edu.nextstep.camp.calculator.domain

sealed class Operator(
    val operator: Char,
    private val calculationBlock: (Double, Double) -> Double
) {
    object Plus : Operator('+', { left, right -> left + right })
    object Minus : Operator('-', { left, right -> left - right })
    object Div : Operator('/', { left, right -> left / right })
    object Mult : Operator('*', { left, right -> left * right })

    operator fun invoke(left: Double, right: Double) = calculationBlock(left, right)

    companion object {
        @Throws(IllegalArgumentException::class)
        fun get(operator: Char): Operator = when (operator) {
            Plus.operator -> Plus
            Minus.operator -> Minus
            Div.operator -> Div
            Mult.operator -> Mult
            else -> throw IllegalArgumentException("wrong operator [$operator]")
        }

        fun getChars() = charArrayOf(Plus.operator, Minus.operator, Div.operator, Mult.operator)
    }
}
