package edu.nextstep.camp.domain

class Calculator(
	private val expressionValidityChecker: ExpressionValidityChecker
) {

	fun evaluate(expressionString: String?): Double {
		val expressionTokens = getValidExpressionTokenListOrThrow(expressionString)

		var result = (expressionTokens.first() as NumberOperandToken).value

		for (index in 1 until expressionTokens.size step 2) {
			val operatorToken = expressionTokens[index] as OperatorToken
			val numberToken = expressionTokens[index + 1] as NumberOperandToken

			result = operatorToken.processOperation(result, numberToken)
		}

		return result
	}

	private fun getValidExpressionTokenListOrThrow(expressionString: String?): List<ExpressionToken> {
		expressionValidityChecker.checkOrThrowException(expressionString)

		val tokens = expressionString?.split(" ") ?: emptyList()

		return List(tokens.size) { index ->
			when {
				index.rem(2) == 0 -> NumberOperandToken(tokens[index])
				else -> OperatorToken.convertOperatorToken(tokens[index])
			}
		}
	}
}
