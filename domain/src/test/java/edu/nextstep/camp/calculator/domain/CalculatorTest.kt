package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    @MockK private lateinit var parser: ExpressionParser
    @InjectMockKs private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
    }

    @Test
    fun `1 더하기 2는 3이다`() {
        // given
        every { parser.parse(any()) } returns Expression(listOf(1, 2), listOf(Sign.PLUS))

        // when
        val actual = calculator.evaluate("1 + 2")

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `3 빼기 2는 1이다`() {
        // given
        every { parser.parse(any()) } returns Expression(listOf(3, 2), listOf(Sign.MINUS))

        // when
        val actual = calculator.evaluate("3 - 2")

        // then
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `2 곱하기 3은 6이다`() {
        // given
        every { parser.parse(any()) } returns Expression(listOf(2, 3), listOf(Sign.TIMES))

        // when
        val actual = calculator.evaluate("2 * 3")

        // then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `10 나누기 2는 5다`() {
        // given
        every { parser.parse(any()) } returns Expression(listOf(10, 2), listOf(Sign.DIVISION))

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

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 공백이면 오류를 던진다`() {
        // when
        calculator.evaluate(" ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `사칙연산이 아닌 기호가 포함되어 있으면 오류를 던진다`() {
        // given
        every { parser.parse(any()) } throws IllegalArgumentException()

        // when
        calculator.evaluate("5 % 3")
    }

    @Test
    fun `2 더하기 3 곱하기 4 나누기 2는 10이다`() {
        // given
        every { parser.parse(any()) } returns Expression(listOf(2, 3, 4, 2), listOf(Sign.PLUS, Sign.TIMES, Sign.DIVISION))

        // when
        val actual = calculator.evaluate("2 + 3 * 4 / 2")

        // then
        assertThat(actual).isEqualTo(10)
    }
}
