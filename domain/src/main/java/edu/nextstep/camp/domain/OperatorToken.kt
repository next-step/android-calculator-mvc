package edu.nextstep.camp.domain

sealed class OperatorToken(tokenString: String) : ExpressionToken(tokenString) {
	object Addition: OperatorToken("+")
	object Subtraction: OperatorToken("-")
	object Multiplication: OperatorToken("×")
	object Division: OperatorToken("÷")
}