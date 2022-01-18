package com.example.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CalculatorTest {
    @Test
    fun evaluatesExpression() {
        //given
        val expression = "2 + 3 * 4 / 2"
        val delimiter = " "
        val expected = 10

        //then
        assertEquals(expected, Calculator.evaluate(expression, delimiter))
    }

    @Test
    fun testNullInput() {
        //given
        val expression = ""
        val delimiter = " "

        //then
        assertThrows<IllegalArgumentException> { Calculator.splitExpression(expression, delimiter) }
    }

}