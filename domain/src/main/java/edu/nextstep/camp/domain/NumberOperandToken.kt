package edu.nextstep.camp.domain

class NumberOperandToken @Throws(NumberFormatException::class) constructor(
	override val token: String
) : ExpressionToken() {
	val value = java.lang.Double.parseDouble(token)

	operator fun plus(other: NumberOperandToken): NumberOperandToken {
		return NumberOperandToken("$token${other.token}")
	}

	fun removeLastDigit(): NumberOperandToken? {
		return if (token.length == 1) {
			null
		} else {
			NumberOperandToken(token.substring(0, token.lastIndex))
		}
	}
}
