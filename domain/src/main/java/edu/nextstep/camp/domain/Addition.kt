package edu.nextstep.camp.domain

internal object Addition: OperatorToken() {
	override val tokenString: String = "+"

	override fun processOperation(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		return tempResult + numberOperandToken.value
	}
}