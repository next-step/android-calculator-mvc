package com.example.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test


class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun 더하기() {
        val actual: Int = calculator.evaluate("1+2+3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun 빼기() {
        val actual: Int = calculator.evaluate("7-2-1")
        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun 곱하기() {
        val actual: Int = calculator.evaluate("2*2*4")
        assertThat(actual).isEqualTo(16)
    }

    @Test
    fun 나누기() {
        val actual: Int = calculator.evaluate("7/2/3")
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun 사칙연산() {
        val actual: Int = calculator.evaluate("1+2/3*5-2")
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `사칙연산 두자리수`() {
        val actual: Int = calculator.evaluate("10*12/4+13-42")
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `인자가 null 일 경우`() {
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate(null) }
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `연산자가 중복된 경우`() {
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("1-2---") }
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `연산자가 없는 경우`() {
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("1123") }
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

}