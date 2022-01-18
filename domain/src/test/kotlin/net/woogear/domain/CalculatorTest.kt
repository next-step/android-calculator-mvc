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
}