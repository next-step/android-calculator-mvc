package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.calculator.domain.Calculator
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
        calculator.input("1 + 2")
        assertThat(calculator.calculate()).isEqualTo(3)

        calculator.input("5 + 2")
        assertThat(calculator.calculate()).isEqualTo(7)

        calculator.input("1000 + 504")
        assertThat(calculator.calculate()).isEqualTo(1504)
    }

    @Test
    fun `음의 정수를 더하면 덧셈의 결과가 정상이다`() {
        calculator.input("1 + -2")
        assertThat(calculator.calculate()).isEqualTo(-1)


        calculator.input("-1 + 2")
        assertThat(calculator.calculate()).isEqualTo(1)


        calculator.input("-1 + -2")
        assertThat(calculator.calculate()).isEqualTo(-3)
    }

    @Test
    fun `0을 더하면 덧셈의 결과가 정상이다`() {
        calculator.input("0 + 2")
        assertThat(calculator.calculate()).isEqualTo(2)

        calculator.input("1 + 0")
        assertThat(calculator.calculate()).isEqualTo(1)

        calculator.input("-10 + 0")
        assertThat(calculator.calculate()).isEqualTo(-10)
    }

    @Test
    fun `양의 정수를 빼면 뺄셈의 결과가 정상이다`() {
        calculator.input("1 - 2")
        assertThat(calculator.calculate()).isEqualTo(-1)

        calculator.input("5 - 2")
        assertThat(calculator.calculate()).isEqualTo(3)

        calculator.input("1000 - 504")
        assertThat(calculator.calculate()).isEqualTo(496)
    }

    @Test
    fun `음의 정수를 빼면 뺄셈의 결과가 정상이다`() {
        calculator.input("1 - -2")
        assertThat(calculator.calculate()).isEqualTo(3)

        calculator.input("-1 - 2")
        assertThat(calculator.calculate()).isEqualTo(-3)

        calculator.input("-1 - -2")
        assertThat(calculator.calculate()).isEqualTo(1)
    }

    @Test
    fun `0을 빼면 뺄셈의 결과가 정상이다`() {
        calculator.input("0 - 2")
        assertThat(calculator.calculate()).isEqualTo(-2)

        calculator.input("1 - 0")
        assertThat(calculator.calculate()).isEqualTo(1)

        calculator.input("-10 - 0")
        assertThat(calculator.calculate()).isEqualTo(-10)
    }

    @Test
    fun `양의 정수를 곱하면 곱셈의 결과가 정상이다`() {
        calculator.input("1 * 2")
        assertThat(calculator.calculate()).isEqualTo(2)

        calculator.input("5 * 2")
        assertThat(calculator.calculate()).isEqualTo(10)

        calculator.input("1000 * 504")
        assertThat(calculator.calculate()).isEqualTo(504000)
    }

    @Test
    fun `음의 정수를 곱하면 곱셈의 결과가 정상이다`() {
        calculator.input("1 * -2")
        assertThat(calculator.calculate()).isEqualTo(-2)

        calculator.input("-1 * 2")
        assertThat(calculator.calculate()).isEqualTo(-2)

        calculator.input("-1 * -2")
        assertThat(calculator.calculate()).isEqualTo(2)
    }

    @Test
    fun `0을 곱하면 곱셈의 결과가 0이다`() {
        calculator.input("0 * 2")
        assertThat(calculator.calculate()).isEqualTo(0)

        calculator.input("1 * 0")
        assertThat(calculator.calculate()).isEqualTo(0)

        calculator.input("-10 * 0")
        assertThat(calculator.calculate()).isEqualTo(0)
    }

    @Test
    fun `양의 정수를 나누면 나눗셈의 결과는 몫이다`() {
        calculator.input("1 / 2")
        assertThat(calculator.calculate()).isEqualTo(0)

        calculator.input("5 / 2")
        assertThat(calculator.calculate()).isEqualTo(2)

        calculator.input("1000 / 504")
        assertThat(calculator.calculate()).isEqualTo(1)
    }

    @Test
    fun `음의 정수를 나누면 나눗셈의 결과가 정상이다`() {
        calculator.input("2 / -2")
        assertThat(calculator.calculate()).isEqualTo(-1)

        calculator.input("-2 / 2")
        assertThat(calculator.calculate()).isEqualTo(-1)

        calculator.input("-2 / -2")
        assertThat(calculator.calculate()).isEqualTo(1)
    }

    @Test
    fun `0으로 나누면 ArithmeticException 이 나온다`() {
        assertThrows(ArithmeticException::class.java) {
            calculator.input("1 / 0")
            calculator.calculate()
        }
        assertThrows(ArithmeticException::class.java) {
            calculator.input("-10 / 0")
            calculator.calculate()
        }
    }

    @Test
    fun `빈 문자열이나 null을 input하면 IllegalArgumentException이 나온다`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.input("")
        }
        assertThrows(IllegalArgumentException::class.java) {
            calculator.input(null)
        }
    }

    @Test
    fun `숫자나 사칙연산 기호가 입력되지 않은 경우 IllegalArgumentException이 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.input("1 a 2 * 1")
        }

        assertThrows(IllegalArgumentException::class.java) {
            calculator.input("a + 5 + 2")
        }
    }

    @Test
    fun `수식을 입력하면 공백을 기준으로 숫자와 연산기호가 나눠진다`() {
        calculator.input("10 + 552 * -1")
        assertThat(calculator.expressionContents[0]).isEqualTo("10")
        assertThat(calculator.expressionContents[1]).isEqualTo("+")
        assertThat(calculator.expressionContents[2]).isEqualTo("552")
        assertThat(calculator.expressionContents[3]).isEqualTo("*")
        assertThat(calculator.expressionContents[4]).isEqualTo("-1")
    }

    @Test
    fun `사칙연산 모두 포함하여 계산하는 기능을 진행한다`() {
        calculator.input("1 + 2 * 10 / 2 + 2")
        assertThat(calculator.calculate()).isEqualTo(17)


        calculator.input("0 + -2 * 10 / 2 + 2")
        assertThat(calculator.calculate()).isEqualTo(-8)
    }
}
