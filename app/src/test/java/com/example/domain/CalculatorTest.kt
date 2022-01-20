package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator
    @Before
    fun init() {
        calculator = Calculator()
    }

    @Test
    fun `공백없는 덧셈이 주어진 경우 계산에 성공한다`() {
        val actual: Int = calculator.evaluate("1+2+3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `공백없는 뺄셈이 주어진 경우 계산에 성공한다`() {
        val actual: Int = calculator.evaluate("3-2-1")
        assertThat(actual).isEqualTo(0)
    }

    @Test
    fun `공백없는 곱셈이 주어진 경우 계산에 성공한다`() {
        val actual: Int = calculator.evaluate("1*2*3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `공백없는 나눗셈이 주어진 경우 계산에 성공한다`() {
        val actual: Int = calculator.evaluate("6/3/2")
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `공백이 있는 덧셈과 뺄셈이 주어진 경우 계산에 성공한다`() {
        val actual: Int = calculator.evaluate("1+2+3 +4 - 5")
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `공백이 있는 곱셈과 나눗셈이 주어진 경우 계산에 성공한다`() {
        val actual: Int = calculator.evaluate("1*2*3 /4 * 5")
        assertThat(actual).isEqualTo(5)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 null인 경우 IllegalArgumentException throw`() {
        val actual = calculator.evaluate(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 빈 문자열인 경우 IllegalArgumentException throw`() {
        val actual = calculator.evaluate("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 공백인 경우 IllegalArgumentException throw`() {
        val actual = calculator.evaluate("   ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        val actual = calculator.evaluate(" $  & 3")
    }
}
