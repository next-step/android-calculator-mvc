package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `더하기`() {
        // when
        val actual = calculator.calculate(listOf("1", "+", "2"))

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        // when
        val actual = calculator.calculate(listOf("5", "-", "3"))

        // then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `곱하기`() {
        // when
        val actual = calculator.calculate(listOf("6", "*", "4"))

        // then
        assertThat(actual).isEqualTo(24)
    }

    @Test
    fun `나누기`() {
        // when
        val actual = calculator.calculate(listOf("9", "/", "3"))

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `0으로 나누기`() {
        // when
        val actual = calculator.calculate(listOf("9", "/", "0"))

        // then
        assertThrows(IllegalArgumentException::class.java) { actual }
    }

    @Test
    fun `입력값이 null이거나 공백 문자이면 오류가 나온다`() {
        // when
        val actual = calculator.toOperand(" ")

        // then
        assertThrows(IllegalArgumentException::class.java) { actual }
    }
}