package edu.nextstep.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `덧셈의 결과가 정상이다`() {
        assertThat(Operator.PLUS.calculate(1, 2)).isEqualTo(3)
        assertThat(Operator.PLUS.calculate(5, 2)).isEqualTo(7)
        assertThat(Operator.PLUS.calculate(1000, 504)).isEqualTo(1504)
    }

    @Test
    fun `음의 정수를 더하면 덧셈의 결과가 정상이다`() {
        assertThat(Operator.PLUS.calculate(1, -2)).isEqualTo(-1)
        assertThat(Operator.PLUS.calculate(-1, 2)).isEqualTo(1)
        assertThat(Operator.PLUS.calculate(-1, -2)).isEqualTo(-3)
    }

    @Test
    fun `0을 더하면 덧셈의 결과가 정상이다`() {
        assertThat(Operator.PLUS.calculate(0, 2)).isEqualTo(2)
        assertThat(Operator.PLUS.calculate(1, 0)).isEqualTo(1)
        assertThat(Operator.PLUS.calculate(-10, 0)).isEqualTo(-10)
    }

    @Test
    fun `양의 정수를 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(Operator.MINUS.calculate(1, 2)).isEqualTo(-1)
        assertThat(Operator.MINUS.calculate(5, 2)).isEqualTo(3)
        assertThat(Operator.MINUS.calculate(1000, 504)).isEqualTo(496)
    }

    @Test
    fun `음의 정수를 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(Operator.MINUS.calculate(1, -2)).isEqualTo(3)
        assertThat(Operator.MINUS.calculate(-1, 2)).isEqualTo(-3)
        assertThat(Operator.MINUS.calculate(-1, -2)).isEqualTo(1)
    }

    @Test
    fun `0을 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(Operator.MINUS.calculate(0, -2)).isEqualTo(2)
        assertThat(Operator.MINUS.calculate(1, 0)).isEqualTo(1)
        assertThat(Operator.MINUS.calculate(-10, 0)).isEqualTo(-10)
    }

    @Test
    fun `양의 정수를 곱하면 곱셈의 결과가 정상이다`() {
        assertThat(Operator.MULTIPLY.calculate(1, 2)).isEqualTo(2)
        assertThat(Operator.MULTIPLY.calculate(5, 2)).isEqualTo(10)
        assertThat(Operator.MULTIPLY.calculate(1000, 504)).isEqualTo(504000)
    }

    @Test
    fun `음의 정수를 곱하면 곱셈의 결과가 정상이다`() {
        assertThat(Operator.MULTIPLY.calculate(1, -2)).isEqualTo(-2)
        assertThat(Operator.MULTIPLY.calculate(-1, 2)).isEqualTo(-2)
        assertThat(Operator.MULTIPLY.calculate(-1, -2)).isEqualTo(2)
    }

    @Test
    fun `0을 곱하면 곱셈의 결과가 0이다`() {
        assertThat(Operator.MULTIPLY.calculate(0, 2)).isEqualTo(0)
        assertThat(Operator.MULTIPLY.calculate(1, 0)).isEqualTo(0)
        assertThat(Operator.MULTIPLY.calculate(-10, 0)).isEqualTo(0)
    }

    @Test
    fun `양의 정수를 나누면 나눗셈의 결과는 몫이다`() {
        assertThat(Operator.DIVIDE.calculate(1, 2)).isEqualTo(0)
        assertThat(Operator.DIVIDE.calculate(5, 2)).isEqualTo(2)
        assertThat(Operator.DIVIDE.calculate(1000, 504)).isEqualTo(1)
    }

    @Test
    fun `음의 정수를 나누면 나눗셈의 결과가 정상이다`() {
        assertThat(Operator.DIVIDE.calculate(2, -2)).isEqualTo(-1)
        assertThat(Operator.DIVIDE.calculate(-2, 2)).isEqualTo(-1)
        assertThat(Operator.DIVIDE.calculate(-2, -2)).isEqualTo(1)
    }

    @Test
    fun `0으로 나누면 ArithmeticException 이 나온다`() {
        assertThrows(ArithmeticException::class.java) {
            Operator.DIVIDE.calculate(1, 0)
        }
        assertThrows(ArithmeticException::class.java) {
            Operator.DIVIDE.calculate(-10, 0)
        }
    }
}
