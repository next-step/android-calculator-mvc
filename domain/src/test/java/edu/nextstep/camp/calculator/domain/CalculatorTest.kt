package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `입력값으로_공백문자가_들어오면_예외를_발생시킨다`() {
        //given
        val input = "  "
        //when
        val actual = runCatching { calculator.evaluate(input) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값으로_NULL이_들어오면_예외를_발생시킨다`() {
        //given
        val input: String? = null
        //when
        val actual = runCatching { calculator.evaluate(input) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산_이외의_기호가_들어오면_예외를_발생시킨다`() {
        //given
        val input = "1 % 2"
        //when
        val actual = runCatching { calculator.evaluate(input) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `12와_6를_더하면_18이다`() {
        //given
        val input = "12 + 6"
        //when
        val actual = calculator.evaluate(input)
        //then
        assertThat(actual).isEqualTo(18)
    }

    @Test
    fun `12에서_6을_빼면_6이다`() {
        //given
        val input = "12 - 6"
        //when
        val actual = calculator.evaluate(input)
        //then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `12와_6을_나누면_2이다`() {
        //given
        val input = "12 / 6"
        //when
        val actual = calculator.evaluate(input)
        //then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `12과_6을_곱하면_72이다`() {
        //given
        val input = "12 * 6"
        //when
        val actual = calculator.evaluate(input)
        //then
        assertThat(actual).isEqualTo(72)
    }
}
