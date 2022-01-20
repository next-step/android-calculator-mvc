package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest() {

    @Test
    fun `두 수를 더하면 정답이 나와야 한다`() {
        // when
        val result = Calculator().plus(5f, 2f)
        // then
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `두 수를 빼면 정답이 나와야 한다`() {
        // when
        val result = Calculator().minus(5f, 2f)
        // then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `두 수를 곱하면 정답이 나와야 한다`() {
        // when
        val result = Calculator().multipliedBy(5f, 2f)
        // then
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `두 수를 나누면 정답이 나와야 한다`() {
        // when
        val result = Calculator().dividedBy(5f, 2f)
        // then
        assertThat(result).isEqualTo(2.5f)
    }

    @Test
    fun `입력된 값은 정답이 나와야 한다`() {
        // when
        val result = Calculator().evaluate("8+2×5÷4")
        // then
        assertThat(result).isEqualTo(12.5f)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력된 값이 없으면 오류가 난다`() {
        // when
        val result = Calculator().evaluate("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `사칙연산이 아닌 경우 오류가 난다`() {
        // when
        val result = Calculator().evaluate("2^3")
    }

}