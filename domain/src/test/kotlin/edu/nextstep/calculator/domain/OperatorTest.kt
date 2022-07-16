package edu.nextstep.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class OperatorTest {
    @Test
    fun `덧셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(1, 2, Operator.PLUS)).isEqualTo(3)
        assertThat(Operator.calculateExpression(5, 2, Operator.PLUS)).isEqualTo(7)
        assertThat(Operator.calculateExpression(1000, 504, Operator.PLUS)).isEqualTo(1504)
    }

    @Test
    fun `음의 정수를 더하면 덧셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(1, -2, Operator.PLUS)).isEqualTo(-1)
        assertThat(Operator.calculateExpression(-1, 2, Operator.PLUS)).isEqualTo(1)
        assertThat(Operator.calculateExpression(-1, -2, Operator.PLUS)).isEqualTo(-3)
    }

    @Test
    fun `0을 더하면 덧셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(0, 2, Operator.PLUS)).isEqualTo(2)
        assertThat(Operator.calculateExpression(1, 0, Operator.PLUS)).isEqualTo(1)
        assertThat(Operator.calculateExpression(-10, 0, Operator.PLUS)).isEqualTo(-10)
    }

    @Test
    fun `양의 정수를 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(1, 2, Operator.MINUS)).isEqualTo(-1)
        assertThat(Operator.calculateExpression(5, 2, Operator.MINUS)).isEqualTo(3)
        assertThat(Operator.calculateExpression(1000, 504, Operator.MINUS)).isEqualTo(496)
    }

    @Test
    fun `음의 정수를 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(1, -2, Operator.MINUS)).isEqualTo(3)
        assertThat(Operator.calculateExpression(-1, 2, Operator.MINUS)).isEqualTo(-3)
        assertThat(Operator.calculateExpression(-1, -2, Operator.MINUS)).isEqualTo(1)
    }

    @Test
    fun `0을 빼면 뺄셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(0, -2, Operator.MINUS)).isEqualTo(2)
        assertThat(Operator.calculateExpression(1, 0, Operator.MINUS)).isEqualTo(1)
        assertThat(Operator.calculateExpression(-10, 0, Operator.MINUS)).isEqualTo(-10)
    }

    @Test
    fun `양의 정수를 곱하면 곱셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(1, 2, Operator.MULTIPLY)).isEqualTo(2)
        assertThat(Operator.calculateExpression(5, 2, Operator.MULTIPLY)).isEqualTo(10)
        assertThat(Operator.calculateExpression(1000, 504, Operator.MULTIPLY)).isEqualTo(504000)
    }

    @Test
    fun `음의 정수를 곱하면 곱셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(1, -2, Operator.MULTIPLY)).isEqualTo(-2)
        assertThat(Operator.calculateExpression(-1, 2, Operator.MULTIPLY)).isEqualTo(-2)
        assertThat(Operator.calculateExpression(-1, -2, Operator.MULTIPLY)).isEqualTo(2)
    }

    @Test
    fun `0을 곱하면 곱셈의 결과가 0이다`() {
        assertThat(Operator.calculateExpression(0, 2, Operator.MULTIPLY)).isEqualTo(0)
        assertThat(Operator.calculateExpression(1, 0, Operator.MULTIPLY)).isEqualTo(0)
        assertThat(Operator.calculateExpression(-10, 0, Operator.MULTIPLY)).isEqualTo(0)
    }

    @Test
    fun `양의 정수를 나누면 나눗셈의 결과는 몫이다`() {
        assertThat(Operator.calculateExpression(1, 2, Operator.DIVIDE)).isEqualTo(0)
        assertThat(Operator.calculateExpression(5, 2, Operator.DIVIDE)).isEqualTo(2)
        assertThat(Operator.calculateExpression(1000, 504, Operator.DIVIDE)).isEqualTo(1)
    }

    @Test
    fun `음의 정수를 나누면 나눗셈의 결과가 정상이다`() {
        assertThat(Operator.calculateExpression(2, -2, Operator.DIVIDE)).isEqualTo(-1)
        assertThat(Operator.calculateExpression(-2, 2, Operator.DIVIDE)).isEqualTo(-1)
        assertThat(Operator.calculateExpression(-2, -2, Operator.DIVIDE)).isEqualTo(1)
    }

    @Test
    fun `0으로 나누면 ArithmeticException 이 나온다`() {
        assertThrows(ArithmeticException::class.java) {
            Operator.calculateExpression(1, 0, Operator.DIVIDE)
        }
        assertThrows(ArithmeticException::class.java) {
            Operator.calculateExpression(-10, 0, Operator.DIVIDE)
        }
    }
}
