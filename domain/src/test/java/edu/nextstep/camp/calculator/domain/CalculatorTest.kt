package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `입력값이_공백이면_예외를_발생시킨다`() {
        //given
        val tokens = emptyList<Token>()
        //when
        val actual = runCatching { calculator.evaluate(tokens) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `연산자_위치에_피연산자가_들어오면_예외를_발생시킨다`() {
        //given
        val tokens = listOf(Operand(1), Operand(1), Operand(2))
        //when
        val actual = runCatching { calculator.evaluate(tokens) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `12와_6를_더하면_18이다`() {
        //given
        val tokens = listOf(Operand(12), Operator.PLUS, Operand(6))
        //when
        val actual = calculator.evaluate(tokens)
        //then
        assertThat(actual).isEqualTo(18)
    }

    @Test
    fun `12에서_6을_빼면_6이다`() {
        //given
        val tokens = listOf(Operand(12), Operator.MINUS, Operand(6))
        //when
        val actual = calculator.evaluate(tokens)
        //then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `12와_6을_나누면_2이다`() {
        //given
        val tokens = listOf(Operand(12), Operator.DIVIDE, Operand(6))
        //when
        val actual = calculator.evaluate(tokens)
        //then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `12과_6을_곱하면_72이다`() {
        //given
        val tokens = listOf(Operand(12), Operator.MULTIPLY, Operand(6))
        //when
        val actual = calculator.evaluate(tokens)
        //then
        assertThat(actual).isEqualTo(72)
    }

    @Test
    fun `12과_6을_더한뒤_2로_곱하면_36이다`() {
        //given
        val tokens = listOf(Operand(12), Operator.PLUS, Operand(6), Operator.MULTIPLY, Operand(2))
        //when
        val actual = calculator.evaluate(tokens)
        //then
        assertThat(actual).isEqualTo(36)
    }
}
