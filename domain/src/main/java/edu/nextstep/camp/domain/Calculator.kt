package edu.nextstep.camp.domain

class Calculator(
	private val expressionTokenConverter: ExpressionTokenConverter
) {
	fun evaluate(expressionString: String?): Double {
		if (expressionString.isNullOrBlank()) {
			throw IllegalArgumentException("expressionString must not be a null or blank String")
		}

		val tokens = expressionString.split(" ")

		val firstExpressionToken = expressionTokenConverter.convert(tokens.first())
		if (firstExpressionToken !is Number) {
			throw IllegalArgumentException("Invalid Expression")
		}

		val lastExpressionToken = expressionTokenConverter.convert(tokens.last())
		if (lastExpressionToken !is Number) {
			throw IllegalArgumentException("Invalid Expression")
		}

		var result = firstExpressionToken.value

		for (index in 1 until tokens.size step 2) {
			val operatorToken = expressionTokenConverter.convert(tokens[index])
			val numberToken = expressionTokenConverter.convert(tokens[index + 1])

			result = processOperator(result, operatorToken, numberToken)
		}

		return result
	}

	internal fun processOperator(tempResult: Double, operatorToken: ExpressionToken, numberToken: ExpressionToken): Double {
		if (operatorToken !is Operator || numberToken !is Number) {
			throw IllegalArgumentException("operatorToken must be a Operator and numberToken must be a Number")
		}

		return when(operatorToken) {
			Operator.Addition -> processAddition(tempResult, numberToken)
			Operator.Subtraction -> processSubtraction(tempResult, numberToken)
			Operator.Multiplication -> processMultiplication(tempResult, numberToken)
			Operator.Division -> processDivision(tempResult, numberToken)
		}
	}

	internal fun processAddition(tempResult: Double, numberToken: Number): Double {
		return tempResult + numberToken.value
	}

	internal fun processSubtraction(tempResult: Double, numberToken: Number): Double {
		return tempResult - numberToken.value
	}

	internal fun processMultiplication(tempResult: Double, numberToken: Number): Double {
		return tempResult * numberToken.value
	}

	internal fun processDivision(tempResult: Double, numberToken: Number): Double {
		if (numberToken.value == 0.toDouble()) {
			throw IllegalArgumentException("Operand value of Division must not be zero")
		}

		return tempResult / numberToken.value
	}
}
