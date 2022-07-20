package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class OperandTest {

    @ParameterizedTest(name = "{0}와 {1}을 더하면 {2}가 된다.")
    @CsvSource(
        "1, 2, 3",
        "11, 12, 23",
        "2000, 4000, 6000",
    )
    fun `두 숫자는 덧셈 연산을 할 수 있다`(first: Int, second: Int, expected: Int) {
        // when
        val result = Operand(first) + Operand(second)

        // then
        assertThat(result).isEqualTo(Operand(expected))
    }

    @ParameterizedTest(name = "{0}에서 {1}을 빼면 {2}가 된다.")
    @CsvSource(
        "10, 1, 9",
        "3, 20, -17",
        "1000, 123, 877",
    )
    fun `두 숫자는 뺄셈 연산을 할 수 있다`(first: Int, second: Int, expected: Int) {
        // when
        val result = Operand(first) - Operand(second)

        // then
        assertThat(result).isEqualTo(Operand(expected))
    }

    @ParameterizedTest(name = "{0}와 {1}을 곱하면 {2}가 된다.")
    @CsvSource(
        "3, 4, 12",
        "10, 10, 100",
        "0, 1000, 0",
    )
    fun `두 숫자는 곱하기 연산을 할 수 있다`(first: Int, second: Int, expected: Int) {
        // when
        val result = Operand(first) * Operand(second)

        // then
        assertThat(result).isEqualTo(Operand(expected))
    }

    @ParameterizedTest(name = "{0}에서 {1}을 나누면 {2}가 된다.")
    @CsvSource(
        "10, 2, 5",
        "3, 1, 3",
        "64, 8, 8",
    )
    fun `두 숫자는 나누기 연산을 할 수 있다`(first: Int, second: Int, expected: Int) {
        // when
        val result = Operand(first) / Operand(second)

        // then
        assertThat(result).isEqualTo(Operand(expected))
    }
}
