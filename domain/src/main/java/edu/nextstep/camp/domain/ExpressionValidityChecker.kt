package edu.nextstep.camp.domain

interface ExpressionValidityChecker {
	fun checkOrThrowException(expression: String?)
}