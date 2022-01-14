package edu.nextstep.camp.calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun evaluatesExpression() {
        val calculator = Calculator()
        val actual = calculator.evaluate("1+2+3")

        assertEquals(6, actual)
    }
}