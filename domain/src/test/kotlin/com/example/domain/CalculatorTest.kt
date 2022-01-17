package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    //덧셈
    @Test
    fun `test plus`() {
        //given
        val input = "1+2+3"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(6)
    }

    //뺄셈
    @Test
    fun `test subtraction`() {
        //given
        val input = "6-3-2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(1)
    }

    //곱셈
    @Test
    fun `test multiplication`() {
        //given
        val input = "6*3*2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(36)
    }

    //나눗셈
    @Test
    fun `test division`() {
        //given
        val input = "6/3/2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(1)
    }

    //입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    @Test
    fun `test input has empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            //given
            val input = " 1+2+3"
            //when
            calculator.evaluate(input)
            //then
        }
    }

    //사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    @Test
    fun `test input is not operator`() {
        assertThrows(IllegalArgumentException::class.java) {
            //given
            val input = "1&2@3"
            //when
            calculator.evaluate(input)
            //then
        }
    }

    //사칙 연산을 모두 포함하는 기능 구현
    @Test
    fun `test input has all operator`() {
        //given
        val input = "1+2*3-1/2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(4)
    }
}
