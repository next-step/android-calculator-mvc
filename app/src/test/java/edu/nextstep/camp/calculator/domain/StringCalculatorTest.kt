package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class StringCalculatorTest {

    private val stringCalculator = StringCalculator

    @ParameterizedTest(name = "사칙연산자 하나가 포함된 {0}의 계산 결과가 {1}를 만족한다.")
    @CsvSource(
        "1 + 2, 3",
        "1004 - 4, 1000",
    )
    fun `사칙연산자 하나가 포함된 문자열의 계산 결과값을 알 수 있다`(original: String, expected: Int) {
        // when
        val result = stringCalculator.calculate(original)

        // then
        assertThat(result).isEqualTo(Number(expected))
    }
}
