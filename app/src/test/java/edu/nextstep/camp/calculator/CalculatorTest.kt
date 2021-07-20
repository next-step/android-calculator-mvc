package edu.nextstep.camp.calculator

import com.google.common.truth.Truth
import org.junit.Test

class CalculatorTest {

    @Test
    fun `6과 7을 plus함수로 더하면 13이 나와야 한다`() {
        val calculator = Calculator()
        val result = calculator.plus(6, 7)
        Truth.assertThat(result).isEqualTo(13)
    }

    @Test
    fun `6과 7을 minus함수로 빼면 -1이 나와야 한다`() {
        val calculator = Calculator()
        val result = calculator.minus(6, 7)
        Truth.assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `6과 7을 multiply함수로 곱하면 42 나와야 한다`() {
        val calculator = Calculator()
        val result = calculator.multiply(6, 7)
        Truth.assertThat(result).isEqualTo(42)
    }

    @Test
    fun `42와 6을 divide함수로 나누면 7이 나와야 한다`() {
        val calculator = Calculator()
        val result = calculator.divide(42, 6)
        Truth.assertThat(result).isEqualTo(7)
    }
}
