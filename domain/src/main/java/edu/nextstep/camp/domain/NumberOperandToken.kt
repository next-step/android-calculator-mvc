package edu.nextstep.camp.domain

internal class NumberOperandToken @Throws(NumberFormatException::class) constructor(
	tokenString: String
) : ExpressionToken(tokenString) {
	val value = java.lang.Double.parseDouble(tokenString)
}
