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
		if (firstExpressionToken !is NumberOperand) {
			throw IllegalArgumentException("Invalid Expression")
		}

		val lastExpressionToken = expressionTokenConverter.convert(tokens.last())
		if (lastExpressionToken !is NumberOperand) {
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
		if (operatorToken !is Operator || numberToken !is NumberOperand) {
			throw IllegalArgumentException("operatorToken must be a Operator and numberToken must be a Number")
		}

		return when(operatorToken) {
			Operator.Addition -> processAddition(tempResult, numberToken)
			Operator.Subtraction -> processSubtraction(tempResult, numberToken)
			Operator.Multiplication -> processMultiplication(tempResult, numberToken)
			Operator.Division -> processDivision(tempResult, numberToken)
		}
	}

	internal fun processAddition(tempResult: Double, numberOperand: NumberOperand): Double {
		return tempResult + numberOperand.value
	}

	internal fun processSubtraction(tempResult: Double, numberOperand: NumberOperand): Double {
		return tempResult - numberOperand.value
	}

	internal fun processMultiplication(tempResult: Double, numberOperand: NumberOperand): Double {
		return tempResult * numberOperand.value
	}

	internal fun processDivision(tempResult: Double, numberOperand: NumberOperand): Double {
		if (numberOperand.value == 0.toDouble()) {
			throw IllegalArgumentException("Operand value of Division must not be zero")
		}

		return tempResult / numberOperand.value
	}
}
