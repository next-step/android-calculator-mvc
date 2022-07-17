package edu.nextstep.camp.domain

internal sealed class Operator(tokenString: String) : ExpressionToken(tokenString) {
	object Addition: Operator("+")
	object Subtraction: Operator("-")
	object Multiplication: Operator("×")
	object Division: Operator("÷")
}