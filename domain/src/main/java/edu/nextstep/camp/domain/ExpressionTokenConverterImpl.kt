package edu.nextstep.camp.domain

internal class ExpressionTokenConverterImpl : ExpressionTokenConverter {

	override fun convert(tokenString: String?): ExpressionToken {
		if (tokenString.isNullOrBlank()) {
			throw IllegalArgumentException("OperationToken string can't not be a empty or blank string")
		}

		if (tokenString.length == 1 && tokenString.first().isDigit().not()) {
			return convertOperator(tokenString)
		}

		return NumberOperandToken(tokenString)
	}

	private fun convertOperator(tokenString: String): ExpressionToken {
		return when (tokenString) {
			OperatorToken.Addition.tokenString -> OperatorToken.Addition
			OperatorToken.Subtraction.tokenString -> OperatorToken.Subtraction
			OperatorToken.Multiplication.tokenString -> OperatorToken.Multiplication
			OperatorToken.Division.tokenString -> OperatorToken.Division
			else -> throw IllegalArgumentException("Unknown operator token string")
		}
	}
}