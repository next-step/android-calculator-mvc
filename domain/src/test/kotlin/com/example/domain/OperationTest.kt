package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class OperationTest {

    @Test
    fun `given operation then check available`() {
        //given
        val plus = "+"
        val subtraction = "-"
        val multiplication = "*"
        val division = "/"
        val and = "&"

        //when
        val resultPlus = Operation.check(plus)
        val resultSubtraction = Operation.check(subtraction)
        val resultMultiplication = Operation.check(multiplication)
        val resultDivision = Operation.check(division)
        val resultAnd = Operation.check(and)

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
        val resultPlus = Operation.get(plus)
        val resultSubtraction = Operation.get(subtraction)
        val resultMultiplication = Operation.get(multiplication)
        val resultDivision = Operation.get(division)
        val resultAnd = Operation.get(and)

        //then
        assertThat(resultPlus).isEqualTo(Operation.PLUS)
        assertThat(resultSubtraction).isEqualTo(Operation.SUBTRACTION)
        assertThat(resultMultiplication).isEqualTo(Operation.MULTIPLICATION)
        assertThat(resultDivision).isEqualTo(Operation.DIVISION)
        assertThat(resultAnd).isEqualTo(null)
    }

    @Test
    fun `given plus then calculate result`() {
        //given
        val input1 = 20f
        val operation = Operation.PLUS
        val input2 = 10f

        //when
        val result = Operation.calculate(input1, operation, input2)

        //then
        assertThat(result).isEqualTo(30f)
    }

    @Test
    fun `given subtraction then calculate result`() {
        //given
        val input1 = 20f
        val operation = Operation.SUBTRACTION
        val input2 = 10f

        //when
        val result = Operation.calculate(input1, operation, input2)

        //then
        assertThat(result).isEqualTo(10f)
    }

    @Test
    fun `given multiplication then calculate result`() {
        //given
        val input1 = 20f
        val operation = Operation.MULTIPLICATION
        val input2 = 10f

        //when
        val result = Operation.calculate(input1, operation, input2)

        //then
        assertThat(result).isEqualTo(200f)
    }

    @Test
    fun `given division then calculate result`() {
        //given
        val input1 = 20f
        val operation = Operation.DIVISION
        val input2 = 10f

        //when
        val result = Operation.calculate(input1, operation, input2)

        //then
        assertThat(result).isEqualTo(2f)
    }
}