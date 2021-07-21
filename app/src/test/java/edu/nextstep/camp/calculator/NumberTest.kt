package edu.nextstep.camp.calculator

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NumberTest {

    @Test(expected = RuntimeException::class)
    fun `숫자로 변환할 수 없는경우 Exception 발생`() {
        val cantConvertString = "t"
        Number(cantConvertString)
    }

    @Test
    fun `6과 7을 더하면 13이 나와야 한다`() {
        // given
        val number = Number(6)
        val number2 = Number(7)

        // when
        val result = number.plus(number2)

        //then
        assertThat(result).isEqualTo(Number(13))
    }

    @Test
    fun `6과 7을 빼면 -1이 나와야 한다`() {
        // given
        val number = Number(6)
        val number2 = Number(7)

        // when
        val result = number.minus(number2)

        //then
        assertThat(result).isEqualTo(Number(-1))
    }

    @Test
    fun `6과 7을 곱하면 42가 나와야 한다`() {
        // given
        val number = Number(6)
        val number2 = Number(7)

        // when
        val result = number.multiply(number2)

        //then
        assertThat(result).isEqualTo(Number(42))
    }

    @Test
    fun `12과 3을 나누면 4가 나와야 한다`() {
        // given
        val number = Number(12)
        val number2 = Number(3)

        // when
        val result = number.divide(number2)

        //then
        assertThat(result).isEqualTo(Number(4))
    }


}