package edu.nextstep.camp.calculator.domain

class Calculator {
    private val calculation = Calculation()
    fun evaluate(input: String): Int {
        require(input.isNotEmpty()){"input's value is not empty"} // 입력값이 빈 공백 문자일 경우 IllegalArgumentException
        val tokens: List<Token> = input.split(" ").map { TokenFactory(it) }
        return calculation.calculate(tokens).getOrThrow()
    }
}
