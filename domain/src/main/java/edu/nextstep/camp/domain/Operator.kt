package edu.nextstep.camp.domain

interface Operator {
	fun convertOperatorToken(tokenString: String): OperatorToken

	fun processOperation(tempResult: Double, operatorToken: OperatorToken, numberOperandToken: NumberOperandToken): Double
}