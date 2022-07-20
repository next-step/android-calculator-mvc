package edu.nextstep.camp.domain

class NumberOperandToken @Throws(NumberFormatException::class) constructor(
	override val token: String
) : ExpressionToken() {
	val value = java.lang.Double.parseDouble(token)

	operator fun plus(other: NumberOperandToken): NumberOperandToken {
		return NumberOperandToken("$token${other.token}")
	}

	fun removeLastDigit(): NumberOperandToken? {
		return when {
			token.length == 1 -> null
			token[token.lastIndex - 1] == FLOATING_POINT_CHARACTER -> NumberOperandToken(token.substring(0, token.lastIndex - 1))
			else -> NumberOperandToken(token.substring(0, token.lastIndex))
		}
	}

	companion object {
		private const val FLOATING_POINT_CHARACTER = '.'
	}
}
