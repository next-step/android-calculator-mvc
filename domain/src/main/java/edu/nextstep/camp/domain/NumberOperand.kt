package edu.nextstep.camp.domain

internal class NumberOperand @Throws(NumberFormatException::class) constructor(
	tokenString: String
) : ExpressionToken(tokenString) {
	val value = java.lang.Double.parseDouble(tokenString)
}
