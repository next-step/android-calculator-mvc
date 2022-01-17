package com.example.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    @Test
    fun evaluatesExpression() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate("1+2+3")
        assertThat(actual).isEqualTo(6)
    }
}