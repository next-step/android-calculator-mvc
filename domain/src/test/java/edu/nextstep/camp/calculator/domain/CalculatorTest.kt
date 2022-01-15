package edu.nextstep.camp.calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculatorTest {

    @DisplayName("기본 수식이 성공하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(
        "1 + 2 + 3 + 4 + 5 = ${1 + 2 + 3 + 4 + 5}",
        "5 - 4 - 3 - 2 - 1 = ${5 - 4 - 3 - 2 - 1}",
        "1 * 2 * 3 * 4 * 5 = ${1 * 2 * 3 * 4 * 5}",
        "5 / 4 / 3 / 2 / 1 = ${5 / 4 / 3 / 2 / 1}",
        "2 + 5 * 8 - 4 / 3 = ${((2 + 5) * 8 - 4) / 3}",
        delimiter = '='
    )
    fun basicExpression(expression: String, result: Int) {
        // then
        assertThat(Calculator.evaluate(expression)).isEqualTo(result)
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(
        "2 + 5 * 8 - 4 % 3 = ${((2 + 5) * 8 - 4) % 3}",
        delimiter = '='
    )
    fun notArithmeticOperatorThrow(expression: String) {
        // then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator.evaluate(expression) }
    }
}