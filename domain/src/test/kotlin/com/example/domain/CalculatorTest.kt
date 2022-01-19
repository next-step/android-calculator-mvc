package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `first value is must number`() {
        val result = assertThrows(IllegalArgumentException::class.java) {
            //given
            val input = "+ 2 + 3"
            //when
            calculator.evaluate(input)
        }
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `given plus when evaluate then show correct result`() {
        //given
        val input = "1 + 2 + 3"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `given subtraction when evaluate then show correct result`() {
        //given
        val input = "6 - 3 - 2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `given multiplication when evaluate then show correct result`() {
        //given
        val input = "6 * 3 * 2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(36)
    }

    @Test
    fun `given division when evaluate then show correct result`() {
        //given
        val input = "6 / 3 / 2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `given null when evaluate then throw error`() {
        val result = assertThrows(IllegalArgumentException::class.java) {
            //given
            val input = ""
            //when
            calculator.evaluate(input)
        }
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `given wrong calculation symbol when evaluate then throw error`() {
        val result = assertThrows(IllegalArgumentException::class.java) {
            //given
            val input = "1 & 2 @ 3"
            //when
            calculator.evaluate(input)
        }
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `given all calculation symbol when evaluate then show correct result`() {
        //given
        val input = "1 + 2 * 3 - 1 / 2"
        //when
        val result = calculator.evaluate(input)
        //then
        assertThat(result).isEqualTo(4)
    }
}
