package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun 문자열을_더하면_덧셈의_결과가_나온다() {
        val actual = calculator.evaluate("1 + 2")
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun 문자열을_빼면_뺄셈의_결과가_나온다() {
        val actual = calculator.evaluate("3 - 2")
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun 문자열을_곱하면_곱셈의_결과가_나온다() {
        val actual = calculator.evaluate("3 * 4")
        assertThat(actual).isEqualTo(12)
    }

    @Test
    fun 문자열을_나누면_나눗셈의_결과가_나온다() {
        val actual = calculator.evaluate("4 / 2")
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun 입력값이_null이거나_빈_공백_문자일_경우_오류가_나온다() {
        val actual = calculator.evaluate("null / 2")
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun 사칙연산_기호가_아닌_경우_오류가_나온다() {
        val actual = calculator.evaluate("4 ! 2")
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun 문자열을_사칙연산하면_사칙연산의_결과가_나온다() {
        val actual = calculator.evaluate("5 + 2 - 1 * 4 / 6")
        assertThat(actual).isEqualTo(4)
    }
}