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
}