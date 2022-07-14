package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    @Test
    fun evaluatesExpression() {
        val actual: Int = Calculator.evaluate("1 + 2 + 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun evaluatesComplexExpression() {
        val actual: Int = Calculator.evaluate("2 + 3 * 4 / 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenUnsupportedOperatorIsPassedThenThrowIllegalArgumentException() {
        Calculator.evaluate("1 _ 1")
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenUnsupportedStringIsGivenThenThrowIllegalArgumentException() {
        Calculator.evaluate("null")
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenEmptyStringIsGivenThenThrowIllegalArgumentException() {
        Calculator.evaluate("")
    }

    @Test(expected = ArithmeticException::class)
    fun whenDividedByZeroThenThrowArithmeticException() {
        Calculator.evaluate("1 / 0")
    }
}
