package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @ParameterizedTest(name = "#{index}) {0} == {1}")
    @CsvSource(
        "1 + 2 + 3, 6",
        "2 + 3 × 4 ÷ 3, 6",
        "0 × 1073741824 + 1, 1",
        "1 - 5 × 1 - 18, -22",
    )
    fun evaluatesExpression(expression: String, expected: Int) {
        val actual: Int = Calculator.evaluate(expression)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "#{index}) {0} throws IllegalArgumentException({1})")
    @CsvSource(
        "-1 + 2 + 3, Wrong Format",
        "1 + 1 + 1 +, Wrong Format",
        "nil, Wrong Format",
        "1 ÷- 5 × 1 ++ 18, Wrong Format",
    )
    fun unsupportedStringPassed_ThrowIllegalArgumentException(expression: String, expectedMessage: String) {
        val exception = assertThrows<IllegalArgumentException> { Calculator.evaluate(expression) }
        assertThat(exception.message).isEqualTo(expectedMessage)
    }

    @Test
    fun whenDividedByZeroThenThrowArithmeticException() {
        assertThrows<ArithmeticException> { Calculator.evaluate("1 ÷ 0") }
    }
}
