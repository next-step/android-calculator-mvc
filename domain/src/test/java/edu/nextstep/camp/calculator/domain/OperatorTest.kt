package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class OperatorTest {

    @Test
    fun 더하기_연산자는_두개의_숫자를_더한_값을_반환한다() {
        //given
        val plusOperator = Operator.PLUS
        //when
        val actual = plusOperator.operate(6, 2)
        //then
        assertThat(actual).isEqualTo(8)
    }

    @Test
    fun 빼기_연산자는_두개의_숫자를_뺀_값을_반환한다() {
        //given
        val minusOperator = Operator.MINUS
        //when
        val actual = minusOperator.operate(6, 2)
        //then
        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun 곱하기_연산자는_두개의_숫자를_곱한_값을_반환한다() {
        //given
        val multiplyOperator = Operator.MULTIPLY
        //when
        val actual = multiplyOperator.operate(6, 2)
        //then
        assertThat(actual).isEqualTo(12)
    }

    @Test
    fun 나누기_연산자는_두개의_숫자를_나눈_값을_반환한다() {
        //given
        val divideOperator = Operator.DIVIDE
        //when
        val actual = divideOperator.operate(6, 2)
        //then
        assertThat(actual).isEqualTo(3)
    }
}
