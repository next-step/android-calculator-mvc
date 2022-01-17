package com.nextstep.domain

import com.google.common.truth.Truth
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import kotlin.math.roundToInt

internal class StringCalculatorTest {

    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException 이 Throw 된다.")
    @ParameterizedTest
    @EmptySource
    fun validateTest_input_null_or_empty(formula: String) {
        val stringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(formula)
        }
    }

    @DisplayName("+ 로 이루어진 연산자들의 계산이 정상적으로 된다.")
    @ParameterizedTest
    @CsvSource(value = ["1 + 2,3", "1 + 4 + 6,11", "10 + 21 + 30 + 0,61"])
    fun calculateTest_plus(formula: String, expected: String) {
        val stringCalculator = StringCalculator()

        val result = stringCalculator.calculate(formula)

        Truth.assertThat(result.roundToInt().toString()).isEqualTo(expected)
    }

    @DisplayName("* 로 이루어진 연산자들의 계산이 정상적으로 된다.")
    @ParameterizedTest
    @CsvSource(value = ["1 * 2,2", "1 * 4 * 6,24", "2 * 21 * 0 * 1,0"])
    fun calculateTest_multiple(formula: String, expected: String) {
        val stringCalculator = StringCalculator()

        val result = stringCalculator.calculate(formula)

        Truth.assertThat(result.roundToInt().toString()).isEqualTo(expected)
    }
}