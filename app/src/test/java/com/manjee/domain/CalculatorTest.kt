package com.manjee.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `123+123=246`() {
        assertThat(calculator.calculate("123+123")).isEqualTo(246)
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