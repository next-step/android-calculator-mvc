package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `expression can not be null`() {
        // given
        val expression = null

        // when
        val result = runCatching { calculator.evaluate(expression) }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `expression can not be blank`() {
        // given
        val expression = "   "

        // when
        val result = runCatching { calculator.evaluate(expression) }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `add two numbers`() {
        // given
        val expression = "1 + 2"

        // when
        val actual = calculator.evaluate(expression)

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `minus two numbers`() {
        // given
        val expression = "1 - 2"

        // when
        val actual = calculator.evaluate(expression)

        // then
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `multiply two numbers`() {
        // given
        val expression = "2 * 6"

        // when
        val actual = calculator.evaluate(expression)

        // then
        assertThat(actual).isEqualTo(12)
    }

    @Test
    fun `divide two numbers`() {
        // given
        val expression = "6 / 2"

        // when
        val actual = calculator.evaluate(expression)

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `only arithmetic operator is supported`() {
        // +, -, *, /

        // given
        val expression = "5 ** 5"

        // when
        val result = runCatching { calculator.evaluate(expression) }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `can evaluate multiple numbers`() {
        // given
        val expressions = "1 + 2 + 3 + 4"

        // when
        val actual = calculator.evaluate(expressions)

        // then
        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun `ignore operator precedence`() {
        // given
        val expression = "2 + 3 * 4 / 2"

        // when
        val actual = calculator.evaluate(expression)

        // then
        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun `only accept expression split by blank`() {
        // given
        val expression = "1+5*3"

        // when
        val actual = runCatching { calculator.evaluate(expression) }

        // then
        assertThat(actual.isFailure).isTrue()
    }
}
