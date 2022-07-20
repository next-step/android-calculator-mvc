package edu.nextstep.camp.domain

internal sealed class OperatorToken : ExpressionToken() {

	internal object Addition : OperatorToken() {
		override val token: String = "+"

		override fun processOperation(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
			return tempResult + numberOperandToken.value
		}
	}

	internal object Subtraction : OperatorToken() {
		override val token: String = "-"

		override fun processOperation(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
			return tempResult - numberOperandToken.value
		}
	}

	internal object Multiplication : OperatorToken() {
		override val token: String = "×"

		override fun processOperation(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
			return tempResult * numberOperandToken.value
		}
	}

	internal object Division : OperatorToken() {
		override val token: String = "÷"

		override fun processOperation(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
			if (numberOperandToken.value == 0.toDouble()) {
				throw IllegalArgumentException("Operand value of Division must not be zero")
			}

			return tempResult / numberOperandToken.value
		}
	}

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