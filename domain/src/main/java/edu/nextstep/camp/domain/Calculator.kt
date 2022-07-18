package edu.nextstep.camp.domain

class Calculator(
	private val operator: Operator
) {
	fun evaluate(expressionString: String?): Double {
		val expressionTokens = getValidExpressionTokenListOrThrow(expressionString)

		var result = (expressionTokens.first() as NumberOperandToken).value

		for (index in 1 until expressionTokens.size step 2) {
			val operatorToken = expressionTokens[index] as OperatorToken
			val numberToken = expressionTokens[index + 1] as NumberOperandToken

			result = operator.processOperation(result, operatorToken, numberToken)
		}

		return result
	}

	private fun getValidExpressionTokenListOrThrow(expressionString: String?): List<ExpressionToken> {
		if (expressionString.isNullOrBlank()) {
			throw IllegalArgumentException("expressionString must not be a null or blank String")
		}

		val tokens = expressionString.split(" ")

		return List(tokens.size) { index ->
			when {
				index.rem(2) == 0 -> NumberOperandToken(tokens[index])
				else -> operator.convertOperatorToken(tokens[index])
			}
		}
	}
}
