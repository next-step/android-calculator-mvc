package edu.nextstep.camp.domain

interface ExpressionTokenConverter {
	fun convert(tokenString: String?): ExpressionToken
}