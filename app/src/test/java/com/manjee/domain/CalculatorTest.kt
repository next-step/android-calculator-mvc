package com.manjee.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `123+123=246`() {
        assertThat(calculator.calculate("123 + 123")).isEqualTo(246)
    }

    @Test
    fun `123 - 5 - 10 - 8`() {
        assertThat(calculator.calculate("123 - 5 - 10 - 8")).isEqualTo(100)
    }

    @Test
    fun `125-123 나누기 2 = 1`() {
        assertThat(calculator.calculate("125 - 123 / 2")).isEqualTo(1)
    }

    @Test
    fun `12 * 12 = 144`() {
        assertThat(calculator.calculate("12 * 12")).isEqualTo(144)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `0으로 나누면 IllegalArgumentException 발생`() {
        calculator.calculate("2 / 0")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력 값이 null이면 IllegalArgumentException 발생`() {
        calculator.calculate(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력 값이 공백이면 IllegalArgumentException 발생`() {
        calculator.calculate("")
    }
}