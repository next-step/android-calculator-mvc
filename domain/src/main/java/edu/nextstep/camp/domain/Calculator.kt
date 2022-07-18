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
		if (firstExpressionToken !is NumberOperandToken) {
			throw IllegalArgumentException("Invalid Expression")
		}

		val lastExpressionToken = expressionTokenConverter.convert(tokens.last())
		if (lastExpressionToken !is NumberOperandToken) {
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
		if (operatorToken !is OperatorToken || numberToken !is NumberOperandToken) {
			throw IllegalArgumentException("operatorToken must be a Operator and numberToken must be a Number")
		}

		return when(operatorToken) {
			OperatorToken.Addition -> processAddition(tempResult, numberToken)
			OperatorToken.Subtraction -> processSubtraction(tempResult, numberToken)
			OperatorToken.Multiplication -> processMultiplication(tempResult, numberToken)
			OperatorToken.Division -> processDivision(tempResult, numberToken)
		}
	}

	internal fun processAddition(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		return tempResult + numberOperandToken.value
	}

	internal fun processSubtraction(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		return tempResult - numberOperandToken.value
	}

	internal fun processMultiplication(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		return tempResult * numberOperandToken.value
	}

	internal fun processDivision(tempResult: Double, numberOperandToken: NumberOperandToken): Double {
		if (numberOperandToken.value == 0.toDouble()) {
			throw IllegalArgumentException("Operand value of Division must not be zero")
		}

		return tempResult / numberOperandToken.value
	}
}
