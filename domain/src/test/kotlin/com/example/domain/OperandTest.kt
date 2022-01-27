package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class OperandTest {

    @Test
    fun `given operation then check available`() {
        //given
        val plus = "+"
        val subtraction = "-"
        val multiplication = "*"
        val division = "/"
        val and = "&"

        //when
        val resultPlus = Operand.check(plus)
        val resultSubtraction = Operand.check(subtraction)
        val resultMultiplication = Operand.check(multiplication)
        val resultDivision = Operand.check(division)
        val resultAnd = Operand.check(and)

        //then
        assertThat(resultPlus).isEqualTo(true)
        assertThat(resultSubtraction).isEqualTo(true)
        assertThat(resultMultiplication).isEqualTo(true)
        assertThat(resultDivision).isEqualTo(true)
        assertThat(resultAnd).isEqualTo(false)
    }

    @Test
    fun `given string then get operation`() {
        //given
        val plus = "+"
        val subtraction = "-"
        val multiplication = "*"
        val division = "/"
        val and = "&"

        //when
        val resultPlus = Operand.get(plus)
        val resultSubtraction = Operand.get(subtraction)
        val resultMultiplication = Operand.get(multiplication)
        val resultDivision = Operand.get(division)
        val resultAnd = Operand.get(and)

        //then
        assertThat(resultPlus).isEqualTo(Operand.PLUS)
        assertThat(resultSubtraction).isEqualTo(Operand.SUBTRACTION)
        assertThat(resultMultiplication).isEqualTo(Operand.MULTIPLICATION)
        assertThat(resultDivision).isEqualTo(Operand.DIVISION)
        assertThat(resultAnd).isEqualTo(null)
    }

    @Test
    fun `given plus then calculate result`() {
        //given
        val input1 = 20f
        val operation = Operand.PLUS
        val input2 = 10f

        //when
        val result = Operand.calculate(input1, operation, input2)

        //then
        assertThat(result).isEqualTo(30f)
    }

    @Test
    fun `given subtraction then calculate result`() {
        //given
        val input1 = 20f
        val operation = Operand.SUBTRACTION
        val input2 = 10f

        //when
        val result = Operand.calculate(input1, operation, input2)

        //then
        assertThat(result).isEqualTo(10f)
    }

    @Test
    fun `given multiplication then calculate result`() {
        //given
        val input1 = 20f
        val operation = Operand.MULTIPLICATION
        val input2 = 10f

        //when
        val result = Operand.calculate(input1, operation, input2)

        //then
        assertThat(result).isEqualTo(200f)
    }

    @Test
    fun `given division then calculate result`() {
        //given
        val input1 = 20f
        val operation = Operand.DIVISION
        val input2 = 10f

        //when
        val result = Operand.calculate(input1, operation, input2)

        //then
        assertThat(result).isEqualTo(2f)
    }
}