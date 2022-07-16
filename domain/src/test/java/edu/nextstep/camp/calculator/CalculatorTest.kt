package edu.nextstep.camp.calculator

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class CalculatorTest {
    @Test
    fun 문자열_더하기를_했을때_정상적으로_더하기가_되는가() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate("1 + 2 + 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun 문자열_빼기를_했을때_빼기가_되는가() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate("10 - 2 - 3")
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun 문자열_곱하기를_했을때_곱하기가_되는가() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate("1 * 2 * 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun 문자열_나누기_했을때_나누기가_되는가() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate("6 / 2 / 3")
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun 입력값이_null일_경우_IllegalArgumentException() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate(null)
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun 입력값이_empty일_경우_IllegalArgumentException() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate("")
        assertThat(actual).isEqualTo("IllegalArgumentException")
    }

    @Test
    fun 사칙연산_기호가_아닌_경우_IllegalArgumentException() {
        val calculator = Calculator()
        val actual: Int = calculator.evaluate("1 & 2")
        assertThat(actual).isEqualTo("IllegalArgumentException")
    }
}