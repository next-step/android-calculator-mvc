package net.woogear.domain

import junit.framework.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `1 plus 2 plus 3 equals 6`() {
        val result: Int = calculator.evaluate("1 + 2 + 3")
        assertEquals(6, result)
    }

    @Test
    fun `10 minus 2 minus 5 equals 3`() {
        val result = calculator.evaluate("10 - 2 - 5")
        assertEquals(3, result)
    }

    @Test
    fun `3 multiplied by 4 multiplied by 2 equals 24`() {
        val result = calculator.evaluate("3 * 4 * 2")
        assertEquals(24, result)
    }

    @Test
    fun `50 divided by 25 equals 2`() {
        val result = calculator.evaluate("50 / 25")
        assertEquals(2, result)
    }

    @Test
    fun `2 plus 3 multiplied by 4 divided by 6 minus 1 equals 3`() {
        val result = calculator.evaluate("2 + 3 * 4 / 5 - 1")
        assertEquals(3, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `null input throws an error`() {
        calculator.evaluate(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `empty input text throws an error`() {
        calculator.evaluate("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `input text contains illegal character throws an_error`() {
        calculator.evaluate("2 & 5")
    }
}