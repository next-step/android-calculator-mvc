package edu.nextstep.camp.domain

class NumberOperandToken @Throws(NumberFormatException::class) constructor(
	tokenString: String
) : ExpressionToken(tokenString) {
	val value = java.lang.Double.parseDouble(tokenString)
}
