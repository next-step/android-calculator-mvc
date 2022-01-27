package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun 첫번째_자리가_숫자가_아닐때_에러가_발생() {
        // given
        val expression = " -3 + 1+ 2"
        // when
        val actualException =
            kotlin.runCatching { calculator.evaluate(expression) }.exceptionOrNull()

        // then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat().contains(Calculator.IS_NOT_MATH_EXPRESSION)
    }

    @Test
    fun 숫자를_0으로_나눌때_에러가_발생() {
        // given
        val expression = " 0 / 9"
        // when
        val actualException =
            kotlin.runCatching { calculator.evaluate(expression) }.exceptionOrNull()
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat().contains(Operator.CANT_DIVIDE)
    }

    @Test
    fun 여러_연산을_계산할때_값의_결과가_나옴() {
        //given
        val expression = " 1 + 2 * 3 -5 /2"
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun 더하기를_이용하여_계산할때_값의_결과가_나옴() {
        //given
        val expression = " 1 + 2 "
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun 빼기를_이용하여_계산할때_값의_결과가_나옴() {
        //given
        val expression = " 6-3 "
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun 곱하기를_이용하여_계산할때_값의_결과가_나옴() {
        //given
        val expression = " 6*3 "
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(18)
    }

    @Test
    fun 나누기를_이용하여_계산할때_값의_결과가_나옴() {
        //given
        val expression = " 9/3 "
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun 계산식이_빈칸_일때_에러가_발생() {
        // given
        val expression = "      "
        // when
        val actualException =
            kotlin.runCatching { calculator.evaluate(expression) }.exceptionOrNull()
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat().contains(Calculator.IS_NOT_NULL_OR_BLANK)
    }
}