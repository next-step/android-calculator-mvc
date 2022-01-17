package net.woogear.domain

import junit.framework.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
    @Test
    fun test_one_plus_two_plus_three() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate("1+2+3")
        assertEquals(6, actual)
    }
}