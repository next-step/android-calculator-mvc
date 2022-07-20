package edu.nextstep.camp.domain

class Calculator {
	companion object {
		private const val numberOperandRegexFormat = "[+-]?(0|[1-9][0-9]*)"
		private val expressionRegex = """$numberOperandRegexFormat( [+\-×÷] $numberOperandRegexFormat)*""".toRegex()
	}

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
		if (expressionString.isNullOrBlank()) {
			throw IllegalArgumentException("expressionString must not be a null or blank String")
		}

		if (expressionRegex.matches(expressionString).not()) {
			throw IllegalArgumentException("Invalid Expression")
		}

		val tokens = expressionString.split(" ")

		return List(tokens.size) { index ->
			when {
				index.rem(2) == 0 -> NumberOperandToken(tokens[index])
				else -> OperatorToken.convertOperatorToken(tokens[index])
			}
		}
	}
}
