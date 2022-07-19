package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class ExpressionTest {
    private val calculator = Calculator()

    @Test
    fun 문자열을_더하면_덧셈의_결과가_나온다() {
        val expression = Expression().apply {
            add(1)
            add(Operator.PLUS)
            add(2)
        }
        val actual = calculator.evaluate(expression)
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun 문자열을_빼면_뺄셈의_결과가_나온다() {
        val expression = Expression().apply {
            add(3)
            add(Operator.MINUS)
            add(2)
        }
        val actual = calculator.evaluate(expression)
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun 문자열을_곱하면_곱셈의_결과가_나온다() {
        val expression = Expression().apply {
            add(3)
            add(Operator.MULTIPLICATION)
            add(4)
        }
        val actual = calculator.evaluate(expression)
        assertThat(actual).isEqualTo(12)
    }

    @Test
    fun 문자열을_나누면_나눗셈의_결과가_나온다() {
        val expression = Expression().apply {
            add(4)
            add(Operator.DIVISION)
            add(2)
        }
        val actual = calculator.evaluate(expression)
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun 입력값이_null이거나_빈_공백_문자일_경우_오류가_나온다() {
        val expression = Expression().apply {
            add(null)
            add(Operator.DIVISION)
            add(2)
        }
        assertThrows(IllegalArgumentException::class.java) { expression }
    }

    @Test
    fun 사칙연산_기호가_아닌_경우_오류가_나온다() {
        val expression = Expression().apply {
            add(4)
            add("!")
            add(2)
        }
        assertThrows(IllegalArgumentException::class.java) { expression }
    }

    @Test
    fun 문자열을_사칙연산하면_사칙연산의_결과가_나온다() {
        val expression = Expression().apply {
            add(5)
            add(Operator.PLUS)
            add(2)
            add(Operator.MINUS)
            add(1)
            add(Operator.MULTIPLICATION)
            add(4)
            add(Operator.DIVISION)
            add(6)
        }
        val actual = calculator.evaluate(expression)
        assertThat(actual).isEqualTo(4)
    }
}