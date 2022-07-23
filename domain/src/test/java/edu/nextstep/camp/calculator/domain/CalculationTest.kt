package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculationTest {

    private val calculation = Calculation()

    @Test
    fun 수식이_연산자부터_시작하면_예외를_발생시킨다() {
        //given
        val tokens = listOf(Operator.PLUS, Operand(1), Operand(2))
        //when
        val actual = runCatching { calculation.calculate(tokens) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun 수식이_연산자로_끝나면_예외를_발생시킨다() {
        //given
        val tokens = listOf(Operand(1), Operand(2), Operator.PLUS)
        //when
        val actual = runCatching { calculation.calculate(tokens) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun 수식이_옳바르다면_계산된_값을_반환한다() {
        //given
        val tokens = listOf(Operand(1), Operator.PLUS, Operand(2), Operator.MULTIPLY, Operand(2))
        //when
        val actual = calculation.calculate(tokens).getOrNull()
        //then
        assertThat(actual).isEqualTo(6)
    }
}
