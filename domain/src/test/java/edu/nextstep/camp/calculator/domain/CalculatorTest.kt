package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `1 더하기 2는 3이다`() {
        // when
        val actual = calculator.evaluate("1 + 2")

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `3 빼기 2는 1이다`() {
        // when
        val actual = calculator.evaluate("3 - 2")

        // then
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `2 곱하기 3은 6이다`() {
        // when
        val actual = calculator.evaluate("2 * 3")

        // then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `10 나누기 2는 5다`() {
        // when
        val actual = calculator.evaluate("10 / 2")

        // then
        assertThat(actual).isEqualTo(5)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 null 이면 오류를 던진다`() {
        // when
        calculator.evaluate(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 빈 문자열이면 오류를 던진다`() {
        // when
        calculator.evaluate("")
    }
}
