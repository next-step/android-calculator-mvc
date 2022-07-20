package edu.nextstep.camp.domain

internal object Division: OperatorToken() {
	override val tokenString: String = "÷"

	override fun processOperation(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		if (numberOperandToken.value == 0.toDouble()) {
			throw IllegalArgumentException("Operand value of Division must not be zero")
		}

		return tempResult / numberOperandToken.value
	}
}