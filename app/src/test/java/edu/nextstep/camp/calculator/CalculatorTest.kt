package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.calculator.domain.Calculator
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun init() {
        calculator = Calculator()
    }

    @Test
    fun `양의 정수를 더하면 덧셈의 결과가 정상이다`() {
        assertThat(calculator.plus(1, 2)).isEqualTo(3)
        assertThat(calculator.plus(5, 2)).isEqualTo(7)
        assertThat(calculator.plus(1000, 504)).isEqualTo(1504)
    }

    @Test
    fun `음의 정수를 더하면 덧셈의 결과가 정상이다`() {
        assertThat(calculator.plus(1, -2)).isEqualTo(-1)
        assertThat(calculator.plus(-1, 2)).isEqualTo(1)
        assertThat(calculator.plus(-1, -2)).isEqualTo(-3)
    }

    @Test
    fun `0을 더하면 덧셈의 결과가 정상이다`() {
        assertThat(calculator.plus(0, 2)).isEqualTo(2)
        assertThat(calculator.plus(1, 0)).isEqualTo(1)
        assertThat(calculator.plus(-10, 0)).isEqualTo(-10)
    }
}
