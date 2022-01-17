package com.nextstep.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

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
}