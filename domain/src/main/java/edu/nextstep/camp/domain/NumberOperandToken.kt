package edu.nextstep.camp.domain

internal class NumberOperandToken @Throws(NumberFormatException::class) constructor(
	override val token: String
) : ExpressionToken() {
	val value = java.lang.Double.parseDouble(token)
}
