package edu.nextstep.camp.domain

data class Expression(
	private val expressionTokenList: List<ExpressionToken> = emptyList()
) {

	operator fun plus(numberOperandToken: NumberOperandToken): Expression {
		val newExpressionValues = when (val lastToken = expressionTokenList.lastOrNull()) {
			is NumberOperandToken -> expressionTokenList.dropLast(1) + (lastToken + numberOperandToken)
			is OperatorToken -> expressionTokenList + numberOperandToken
			null -> listOf(numberOperandToken)
			else -> throw IllegalArgumentException("Invalid Plus Operation - lastToken : ${lastToken.token}, numberOperandToken : ${numberOperandToken.token}")
		}

		return Expression(newExpressionValues)
	}

	operator fun plus(operatorToken: OperatorToken): Expression {
		val newExpressionValues = when (val lastToken = expressionTokenList.lastOrNull()) {
			is NumberOperandToken -> expressionTokenList + operatorToken
			is OperatorToken -> expressionTokenList.dropLast(1) + operatorToken
			null -> emptyList()
			else -> throw IllegalArgumentException("Invalid Plus Operation - lastToken : ${lastToken.token}, operatorToken: ${operatorToken.token}")
		}

		return Expression(newExpressionValues)
	}

	fun removeLastCharacter(): Expression {
		val newExpressionValues = when (val lastToken = expressionTokenList.lastOrNull()) {
			is NumberOperandToken -> expressionTokenList.removeLastNumberOperandTokenDigit(lastToken)
			is OperatorToken -> expressionTokenList.dropLast(1)
			null -> emptyList()
			else -> throw IllegalStateException("Current Expression state is not valid")
		}

		return Expression(newExpressionValues)
	}

	private fun List<ExpressionToken>.removeLastNumberOperandTokenDigit(lastToken: NumberOperandToken): List<ExpressionToken> {
		val newLastNumberOperandToken = lastToken.removeLastDigit() ?: return this.dropLast(1)
		return this.dropLast(1) + newLastNumberOperandToken
	}

	override fun toString() = expressionTokenList.joinToString(" ") { it.token }
}