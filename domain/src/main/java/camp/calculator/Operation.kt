package edu.nextstep.camp.calculator.domain.camp.calculator

sealed class Operation(
    val operator: Char,
    private val calculationBlock: (Double, Double) -> Double
) {
    object Plus : Operation('+', { left, right -> left + right })
    object Minus : Operation('-', { left, right -> left - right })
    object Div : Operation('/', { left, right -> left / right })
    object Mult : Operation('*', { left, right -> left * right })

    operator fun invoke(left: Double, right: Double) = calculationBlock(left, right)

    companion object {

        val OPERATOR_SPLIT_REGEX = "[0-9]".toRegex()

        @Throws(IllegalArgumentException::class)
        fun get(operator: Char): Operation = when (operator) {
            Plus.operator -> Plus
            Minus.operator -> Minus
            Div.operator -> Div
            Mult.operator -> Mult
            else -> throw IllegalArgumentException("wrong operator [$operator]")
        }

        fun getChars() = charArrayOf(Plus.operator, Minus.operator, Div.operator, Mult.operator)

        fun getOperators(text: String): List<Char> {
            return text
                .split(OPERATOR_SPLIT_REGEX)
                .filter { it.isNotBlank() }
                .map { it.trim().also { trimmed -> if(trimmed.length > 1) throw IllegalArgumentException("잘못된 연산자가 포함되었습니다.")  }.last() }
        }
    }
}