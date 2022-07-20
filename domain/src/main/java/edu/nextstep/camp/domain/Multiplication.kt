package edu.nextstep.camp.domain

internal object Multiplication : OperatorToken() {
	override val token: String = "×"

	override fun processOperation(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		return tempResult * numberOperandToken.value
	}
}