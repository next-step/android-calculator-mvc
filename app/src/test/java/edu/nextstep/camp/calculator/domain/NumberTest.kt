package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class NumberTest {

    @ParameterizedTest(name = "{0}와 {1}을 더하면 {2}를 리턴한다.")
    @CsvSource(
        "1, 2, 3",
        "11, 12, 23",
        "2000, 4000, 6000",
    )
    fun `두 숫자는 덧셈 연산을 할 수 있다`(first: Int, second: Int, expected: Int) {
        // when
        val result = Number(first) + Number(second)

        // then
        assertThat(result).isEqualTo(Number(expected))
    }
}
