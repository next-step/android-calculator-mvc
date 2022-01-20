package net.woogear.domain

import junit.framework.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `1 더하기 2 더하기 3 = 6`() {
        val result: Int = calculator.evaluate("1 + 2 + 3")
        assertEquals(6, result)
    }

    @Test
    fun `10 빼기 2 빼기 5 = 3`() {
        val result = calculator.evaluate("10 - 2 - 5")
        assertEquals(3, result)
    }

    @Test
    fun `3 곱하기 by 4 곱하기 2 = 24`() {
        val result = calculator.evaluate("3 * 4 * 2")
        assertEquals(24, result)
    }

    @Test
    fun `50 나누기 25 = 2`() {
        val result = calculator.evaluate("50 / 25")
        assertEquals(2, result)
    }

    @Test
    fun `2 더하기 3 곱하기 4 나누기 6 빼기 1 = 3`() {
        val result = calculator.evaluate("2 + 3 * 4 / 5 - 1")
        assertEquals(3, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 null 이면 error 발생`() {
        calculator.evaluate(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값이 공백이면 error 발생`() {
        calculator.evaluate("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `입력값에 연산기호 외의 문자가 들어가면 error 발생`() {
        calculator.evaluate("2 & 5")
    }
}