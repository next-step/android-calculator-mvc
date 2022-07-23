package edu.nextstep.camp.calculator.domain

class Calculator {
    private val calculation = Calculation()
    fun evaluate(tokens: List<Token>): Int {
        require(tokens.isNotEmpty()) { "input's value is not empty" } // 입력값이 빈 공백 문자일 경우 IllegalArgumentException
        return calculation.calculate(tokens).getOrThrow()
    }
}
