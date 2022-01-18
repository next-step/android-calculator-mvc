package net.woogear.domain

import junit.framework.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun test_one_plus_two_plus_three() {
        val result: Int = calculator.evaluate("1 + 2 + 3")
        assertEquals(6, result)
    }

    @Test
    fun ten_minus_two_minus_five() {
        val result = calculator.evaluate("10 - 2 - 5")
        assertEquals(3, result)
    }

    @Test
    fun three_times_four_times_two() {
        val result = calculator.evaluate("3 * 4 * 2")
        assertEquals(24, result)
    }

    @Test
    fun fifty_divided_by_twenty_five() {
        val result = calculator.evaluate("50 / 25")
        assertEquals(2, result)
    }
}