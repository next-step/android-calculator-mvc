package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun whenFirstValueIsNotNumber() {
        val result = assertThrows(IllegalArgumentException::class.java) {
            // given
            val expression = " -3 + 1+ 2"
            // when
            calculator.evaluate(expression)
        }
        // then
        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result).hasMessageThat().contains(Calculator.IS_NOT_MATH_EXPRESSION)
    }

    @Test
    fun whenZeroDivideNumber(){
        val result = assertThrows(IllegalArgumentException::class.java) {
            // given
            val expression = " 0 / 9"
            // when
            calculator.evaluate(expression)
        }
        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result).hasMessageThat().contains(Operator.CANT_DIVIDE)
    }

    @Test
    fun when_calculate_combination_operation() {
        //given
        val expression = " 1 + 2 * 3 -5 /2"
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun when_calculate_plus_operation() {
        //given
        val expression = " 1 + 2 "
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun when_calculate_minus_operation() {
        //given
        val expression = " 6-3 "
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun when_calculate_multiply_operation() {
        //given
        val expression = " 6*3 "
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(18)
    }

    @Test
    fun when_calculate_divide_operation() {
        //given
        val expression = " 9/3 "
        //when
        val result = calculator.evaluate(expression)
        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun when_expression_is_blank() {
        val result = assertThrows(IllegalArgumentException::class.java) {
            // given
            val expression = "      "
            // when
            calculator.evaluate(expression)
        }
        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result).hasMessageThat().contains(Calculator.IS_NOT_NULL_OR_BLANK)
    }
}