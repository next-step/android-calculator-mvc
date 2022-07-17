package edu.nextstep.camp.domain

internal class ExpressionTokenConverterImpl : ExpressionTokenConverter {

	override fun convert(tokenString: String?): ExpressionToken {
		if (tokenString.isNullOrBlank()) {
			throw IllegalArgumentException("OperationToken string can't not be a empty or blank string")
		}

		if (tokenString.length == 1 && tokenString.first().isDigit().not()) {
			return convertOperator(tokenString)
		}

		return Number(tokenString)
	}

	private fun convertOperator(tokenString: String): ExpressionToken {
		return when (tokenString) {
			Operator.Addition.tokenString -> Operator.Addition
			Operator.Subtraction.tokenString -> Operator.Subtraction
			Operator.Multiplication.tokenString -> Operator.Multiplication
			Operator.Division.tokenString -> Operator.Division
			else -> throw IllegalArgumentException("Unknown operator token string")
		}
	}
}