package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `given plus then show correct result`() {
        //given
        val input = "1+2+3"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `given subtraction then show correct result`() {
        //given
        val input = "6-3-2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `given multiplication then show correct result`() {
        //given
        val input = "6*3*2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(36)
    }

    @Test
    fun `given division then show correct result`() {
        //given
        val input = "6/3/2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `given null then throw error`() {
        assertThrows(IllegalArgumentException::class.java) {
            //given
            val input = " 1+2+3"
            //when
            calculator.evaluate(input)
            //then
        }
    }

    @Test
    fun `given wrong calculation symbol then throw error`() {
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
    fun `given all calculation symbol then show correct result`() {
        //given
        val input = "1+2*3-1/2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(4)
    }
}
