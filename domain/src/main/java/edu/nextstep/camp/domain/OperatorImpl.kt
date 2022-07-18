package edu.nextstep.camp.domain

internal class OperatorImpl : Operator {

	override fun convertOperatorToken(tokenString: String): OperatorToken {
		return when (tokenString) {
			OperatorToken.Addition.tokenString -> OperatorToken.Addition
			OperatorToken.Subtraction.tokenString -> OperatorToken.Subtraction
			OperatorToken.Multiplication.tokenString -> OperatorToken.Multiplication
			OperatorToken.Division.tokenString -> OperatorToken.Division
			else -> throw IllegalArgumentException("Unknown operator token string")
		}
	}

	override fun processOperation(tempResult: Double, operatorToken: OperatorToken, numberOperandToken: NumberOperandToken): Double {
		return when(operatorToken) {
			OperatorToken.Addition -> processAddition(tempResult, numberOperandToken)
			OperatorToken.Subtraction -> processSubtraction(tempResult, numberOperandToken)
			OperatorToken.Multiplication -> processMultiplication(tempResult, numberOperandToken)
			OperatorToken.Division -> processDivision(tempResult, numberOperandToken)
		}
	}

	private fun processAddition(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		return tempResult + numberOperandToken.value
	}

	private fun processSubtraction(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		return tempResult - numberOperandToken.value
	}

	private fun processMultiplication(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		return tempResult * numberOperandToken.value
	}

	private fun processDivision(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		if (numberOperandToken.value == 0.toDouble()) {
			throw IllegalArgumentException("Operand value of Division must not be zero")
		}

		return tempResult / numberOperandToken.value
	}
}