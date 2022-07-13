package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class StringCalculatorTest {

    private val stringCalculator = StringCalculator

    @Test
    internal fun `덧셈 연산자가 포함된 문자열의 계산 결과값을 알 수 있다`() {
        // when
        val result = stringCalculator.calculate("1 + 2")

        // then
        assertThat(result).isEqualTo(Number(3))
    }
}
