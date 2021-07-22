package edu.nextstep.camp.domain.stringcalculator

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

/**
 * Created By Malibin
 * on 7월 23, 2021
 */

class StringCalculatorTest {
    @Test
    fun `입력한 문자열 수식에 맞는 결과를 반환 한다`() {
        // given
        val expression = "2 + 3 * 4 / 2"
        val expectedResult = 10

        // when
        val actualResult = StringCalculator.calculate(expression)

        // then
        assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `빈 수식 입력 시 Exception`() {
        // then
        assertThrows(IllegalArgumentException::class.java) { StringCalculator.calculate("") }
            .also { assertThat(it).hasMessageThat().contains("빈 수식은 계산할 수 없습니다.") }
    }

    @Test
    fun `숫자 자리에 다른 문자가 들어가면 Exception`() {
        // when
        val expression = "+ 1 * 2"

        // then
        assertThrows(IllegalArgumentException::class.java) { StringCalculator.calculate(expression) }
            .also { assertThat(it).hasMessageThat().contains("수식의 숫자 자리에 숫자가 아닌 문자 (+)가 존재합니다.") }
    }

    @Test
    fun `연산자 자리에 다른 문자가 들어가면 Exception`() {
        // when
        val expression = "1 2 3"

        // then
        assertThrows(IllegalArgumentException::class.java) { StringCalculator.calculate(expression) }
            .also { assertThat(it).hasMessageThat().contains("2 을 가진 연산자를 찾을 수 없습니다.") }
    }
}
