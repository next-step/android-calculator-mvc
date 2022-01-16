package edu.nextstep.camp.calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculatorTest {

    @DisplayName("기본 수식이 성공하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(
        "1 + 2 + 3 + 4 + 5 = 15",
        "5 - 4 - 3 - 2 - 1 = -5",
        "1 * 2 * 3 * 4 * 5 = 120",
        "5 / 4 / 3 / 2 / 1 = 0",
        "2 + 5 * 8 - 4 / 3 = 17",
        delimiter = '='
    )
    fun basicExpression(expression: String, result: Int) {
        // given
        val delimiter = " "

        // then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(result)
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(
        "2 + 5 * 8 - 4 % 3 = ${((2 + 5) * 8 - 4) % 3}",
        delimiter = '='
    )
    fun notArithmeticOperatorThrow(expression: String) {
        // given
        val delimiter = " "

        // then
        assertThrows<IllegalArgumentException> { Calculator.evaluate(expression, delimiter) }
    }
}