package edu.nextstep.camp.domain

class ExpressionValidityCheckerImpl: ExpressionValidityChecker {

	override fun checkOrThrowException(expression: String?) {

		if (expression.isNullOrBlank()) {
			throw IllegalArgumentException("expressionString must not be a null or blank String")
		}

		if (expressionRegex.matches(expression).not()) {
			throw IllegalArgumentException("Invalid Expression")
		}
	}

	companion object {
		private const val numberOperandRegexFormat = "[+-]?(0|[1-9][0-9]*)(.[0-9]+)?"
		private val expressionRegex = """$numberOperandRegexFormat( [+\-×÷] $numberOperandRegexFormat)*""".toRegex()
	}
}