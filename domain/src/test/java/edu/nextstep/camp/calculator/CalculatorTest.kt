package edu.nextstep.camp.calculator

import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.Before

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun 문자열_더하기를_했을때_정상적으로_더하기가_되는가() {
        val actual: Int = calculator.evaluate("1 + 2 + 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun 문자열_빼기를_했을때_빼기가_되는가() {
        val actual: Int = calculator.evaluate("10 - 2 - 3")
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun 문자열_곱하기를_했을때_곱하기가_되는가() {
        val actual: Int = calculator.evaluate("1 * 2 * 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun 문자열_나누기_했을때_나누기가_되는가() {
        val actual: Int = calculator.evaluate("6 / 2 / 3")
        assertThat(actual).isEqualTo(1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun 입력값이_null일_경우_IllegalArgumentException() {
        calculator.evaluate(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun 입력값이_empty일_경우_IllegalArgumentException() {
        calculator.evaluate("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 사칙연산_기호가_아닌_경우_IllegalArgumentException() {
        calculator.evaluate("1 & 2")
    }

    @Test
    fun 최종_결과가_마이너스인_경우() {
        val actual: Int = calculator.evaluate("6 - 5 - 3")
        assertThat(actual).isEqualTo(-2)
    }

    @Test
    fun 나눗셈에서_큰수로_나누어서_결과가_0이_되는_경우() {
        val actual: Int = calculator.evaluate("3 / 10")
        assertThat(actual).isEqualTo(0)
    }
}