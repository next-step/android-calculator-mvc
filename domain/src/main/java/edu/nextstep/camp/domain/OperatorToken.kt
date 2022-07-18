package edu.nextstep.camp.domain

internal sealed class OperatorToken(tokenString: String) : ExpressionToken(tokenString) {
	object Addition: OperatorToken("+")
	object Subtraction: OperatorToken("-")
	object Multiplication: OperatorToken("×")
	object Division: OperatorToken("÷")
}