package com.manjee.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `123+123=246`() {
        val result = calculator.calculate("123+123")
        assertThat(result).isEqualTo(246)
    }
}