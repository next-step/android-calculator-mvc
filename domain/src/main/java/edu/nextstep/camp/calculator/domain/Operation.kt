package edu.nextstep.camp.calculator.domain

sealed class Operation(
    internal val char: Char,
    private val invoker: (Int, Int) -> Int
) {
    object Plus : Operation('+', { left, right -> left + right })
    object Minus : Operation('-', { left, right -> left - right })
    object Div : Operation('/', { left, right -> left / right })
    object Mult : Operation('*', { left, right -> left * right })

    operator fun invoke(left: Int, right: Int) = invoker.invoke(left, right)

    companion object {
        @Throws(IllegalArgumentException::class)
        fun get(operator: Char): Operation = when (operator) {
            Plus.char -> Plus
            Minus.char -> Minus
            Div.char -> Div
            Mult.char -> Mult
            else -> throw IllegalArgumentException("wrong operator [$operator]")
        }

        fun getChars() = charArrayOf(Plus.char, Minus.char, Div.char, Mult.char)
    }
}
