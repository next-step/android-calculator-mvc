package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `1 더하기 2는 3이다`() {
        // when
        val actual = calculator.evaluate("1 + 2")

        // then
        assertThat(actual).isEqualTo(3)
    }
}
