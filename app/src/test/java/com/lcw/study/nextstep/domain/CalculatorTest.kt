package com.lcw.study.nextstep.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun 더하기() {
        val result: Int = calculator.evaluate("1 + 2 + 3")
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun 빼기() {
        val result: Int = calculator.evaluate("3 - 2 - 1")
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun 곱하기() {
        val result: Int = calculator.evaluate("1 * 2 * 3")
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun 나누기() {
        val result: Int = calculator.evaluate("4 / 2 / 1")
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun 사칙연산() {
        val result: Int = calculator.evaluate("3 + 2 - 1 * 5 / 5")
        assertThat(result).isEqualTo(4)
    }
}