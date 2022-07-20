package edu.nextstep.camp.domain

internal abstract class OperatorToken : ExpressionToken() {

	abstract fun processOperation(tempResult: Double, numberOperandToken: NumberOperandToken): Double

	companion object {
		fun convertOperatorToken(tokenString: String): OperatorToken {
			return when (tokenString) {
				Addition.token -> Addition
				Subtraction.token -> Subtraction
				Multiplication.token -> Multiplication
				Division.token -> Division
				else -> throw IllegalArgumentException("Unknown operator token string")
			}
		}
	}
}