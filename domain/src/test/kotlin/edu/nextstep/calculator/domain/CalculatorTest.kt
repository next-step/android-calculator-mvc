package edu.nextstep.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
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
        assertThat(calculator.calculate("1 + 2")).isEqualTo(3)
        assertThat(calculator.calculate("5 + 2")).isEqualTo(7)
        assertThat(calculator.calculate("1000 + 504")).isEqualTo(1504)
    }

    @Test
    fun `음의 정수를 더하면 덧셈의 결과가 정상이다`() {
        assertThat(calculator.calculate("1 + -2")).isEqualTo(-1)
        assertThat(calculator.calculate("-1 + 2")).isEqualTo(1)
        assertThat(calculator.calculate("-1 + -2")).isEqualTo(-3)
    }

    @Test
    fun `0을 더하면 덧셈의 결과가 정상이다`() {
        assertThat(calculator.calculate("0 + 2")).isEqualTo(2)
        assertThat(calculator.calculate("1 + 0")).isEqualTo(1)
        assertThat(calculator.calculate("-10 + 0")).isEqualTo(-10)
    }

    @Test
    fun `양의 정수를 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(calculator.calculate("1 - 2")).isEqualTo(-1)
        assertThat(calculator.calculate("5 - 2")).isEqualTo(3)
        assertThat(calculator.calculate("1000 - 504")).isEqualTo(496)
    }

    @Test
    fun `음의 정수를 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(calculator.calculate("1 - -2")).isEqualTo(3)
        assertThat(calculator.calculate("-1 - 2")).isEqualTo(-3)
        assertThat(calculator.calculate("-1 - -2")).isEqualTo(1)
    }

    @Test
    fun `0을 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(calculator.calculate("0 - 2")).isEqualTo(-2)
        assertThat(calculator.calculate("1 - 0")).isEqualTo(1)
        assertThat(calculator.calculate("-10 - 0")).isEqualTo(-10)
    }

    @Test
    fun `양의 정수를 곱하면 곱셈의 결과가 정상이다`() {
        assertThat(calculator.calculate("1 * 2")).isEqualTo(2)
        assertThat(calculator.calculate("5 * 2")).isEqualTo(10)
        assertThat(calculator.calculate("1000 * 504")).isEqualTo(504000)
    }

    @Test
    fun `음의 정수를 곱하면 곱셈의 결과가 정상이다`() {
        assertThat(calculator.calculate("1 * -2")).isEqualTo(-2)
        assertThat(calculator.calculate("-1 * 2")).isEqualTo(-2)
        assertThat(calculator.calculate("-1 * -2")).isEqualTo(2)
    }

    @Test
    fun `0을 곱하면 곱셈의 결과가 0이다`() {
        assertThat(calculator.calculate("0 * 2")).isEqualTo(0)
        assertThat(calculator.calculate("1 * 0")).isEqualTo(0)
        assertThat(calculator.calculate("-10 * 0")).isEqualTo(0)
    }

    @Test
    fun `양의 정수를 나누면 나눗셈의 결과는 몫이다`() {
        assertThat(calculator.calculate("1 / 2")).isEqualTo(0)
        assertThat(calculator.calculate("5 / 2")).isEqualTo(2)
        assertThat(calculator.calculate("1000 / 504")).isEqualTo(1)
    }

    @Test
    fun `음의 정수를 나누면 나눗셈의 결과가 정상이다`() {
        assertThat(calculator.calculate("2 / -2")).isEqualTo(-1)
        assertThat(calculator.calculate("-2 / 2")).isEqualTo(-1)
        assertThat(calculator.calculate("-2 / -2")).isEqualTo(1)
    }

    @Test
    fun `0으로 나누면 ArithmeticException 이 나온다`() {
        assertThrows(ArithmeticException::class.java) {
            calculator.calculate("1 / 0")
        }
        assertThrows(ArithmeticException::class.java) {
            calculator.calculate("-10 / 0")
        }
    }

    @Test
    fun `빈 문자열이나 null을 input하면 IllegalArgumentException이 나온다`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("")
        }
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate(null)
        }
    }

    @Test
    fun `숫자나 사칙연산 기호가 입력되지 않은 경우 IllegalArgumentException이 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("1 a 2 * 1")
        }

        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("a + 5 + 2")
        }
    }

    @Test
    fun `사칙연산 모두 포함하여 계산하는 기능을 진행한다`() {
        assertThat(calculator.calculate("1 + 2 * 10 / 2 + 2")).isEqualTo(17)
        assertThat(calculator.calculate("0 + -2 * 10 / 2 + 2")).isEqualTo(-8)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `피연산자 자리에 연산자가 들어가는 경우 IllegalArgumentException가 발생한다`() {
        calculator.calculate("+ + 5")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `연산자와 피연산자를 구분하지 않는 경우 IllegalArgumentException가 발생한다`() {
        calculator.calculate("5+5")
    }
}
