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
			token[token.lastIndex - 1] == NEGATIVE_NUMBER_INDICATOR -> null
			token[token.lastIndex - 1] == POSITIVE_NUMBER_INDICATOR -> null
			token[token.lastIndex - 1] == FLOATING_POINT_CHARACTER -> NumberOperandToken(token.substring(0, token.lastIndex - 1))
			else -> NumberOperandToken(token.substring(0, token.lastIndex))
		}
	}

	companion object {
		private const val FLOATING_POINT_CHARACTER = '.'
		private const val NEGATIVE_NUMBER_INDICATOR = '-'
		private const val POSITIVE_NUMBER_INDICATOR = '+'
	}
}
