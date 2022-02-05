package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class OperatorTest(
    private val operator: Char,
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getTestParameters(): Collection<Array<Char>> {
            return listOf(
                arrayOf('+'),
                arrayOf('-'),
                arrayOf('*'),
                arrayOf('/'),
            )
        }
    }

    @Test
    fun `가능한_연산자_찾기`() {
        //when
        val result = Operator.find(operator).symbol

        //then
        assertThat(result).isEqualTo(operator)

    }

    @Test
    fun `더하기_일때_숫자_계산`() {
        //given
        val input1 = 1
        val operation = Operator.Plus
        val input2 = 3

        //when
        val result = operation.calculateStrategy(input1, input2)

        //then
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `빼기_일때_숫자_계산`() {
        //given
        val input1 = 2
        val operation = Operator.Minus
        val input2 = 1

        //when
        val result = operation.calculateStrategy(input1, input2)

        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `곱하기_일때_숫자_계산`() {
        //given
        val input1 = 2
        val operation = Operator.Multiply
        val input2 = 1

        //when
        val result = operation.calculateStrategy(input1, input2)

        //then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `나누기_일때_숫자_계산`() {
        //given
        val input1 = 2
        val operation = Operator.Divide
        val input2 = 1

        //when
        val result = operation.calculateStrategy(input1, input2)

        //then
        assertThat(result).isEqualTo(2)
    }
}