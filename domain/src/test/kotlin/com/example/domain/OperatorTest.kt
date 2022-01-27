package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class OperatorTest {
    @Test
    fun `가능한_연산자_찾기`() {
        //given
        val plus = '+'
        val minus = '-'
        val multiply = '*'
        val divide = '/'
        val equal = '='

        //when
        val resultPlus = Operator.findOperator(plus).symbol
        val resultMinus = Operator.findOperator(minus).symbol
        val resultMultiply = Operator.findOperator(multiply).symbol
        val resultDivide = Operator.findOperator(divide).symbol
        val resultEqual = kotlin.runCatching { Operator.findOperator(equal).symbol }.exceptionOrNull()

        //then
        assertThat(resultPlus).isEqualTo('+')
        assertThat(resultMinus).isEqualTo('-')
        assertThat(resultMultiply).isEqualTo('*')
        assertThat(resultDivide).isEqualTo('/')
        assertThat(resultEqual).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(resultEqual).hasMessageThat().contains(Operator.CANT_EXIST_OPERATOR)
    }

    @Test
    fun `더하기_일때_숫자_계산`() {
        //given
        val input1 = 1
        val operation = Operator.Plus
        val input2 = 3

        //when
        val result = operation.operate(input1, input2)

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
        val result = operation.operate(input1, input2)

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
        val result = operation.operate(input1, input2)

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
        val result = operation.operate(input1, input2)

        //then
        assertThat(result).isEqualTo(2)
    }
}