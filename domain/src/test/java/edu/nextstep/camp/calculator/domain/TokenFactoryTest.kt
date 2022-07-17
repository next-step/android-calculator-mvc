package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TokenFactoryTest {

    @Test
    fun `인자로_정수가_들어오면_Operand를 반환한다`() {
        //given
        val value = "1"
        //when
        val actual = TokenFactory(value)
        //then
        assertThat(actual).isInstanceOf(Operand::class.java)
    }

    @Test
    fun `인자로_사칙연산_기호가_들어오면_Operator를 반환한다`() {
        //given
        val value = "+"
        //when
        val actual = TokenFactory(value)
        //then
        assertThat(actual).isInstanceOf(Operator::class.java)
    }

    @Test
    fun `인자로_실수가_들어오면_예외를_발생시킨다`() {
        //given
        val value = "1.1"
        //when
        val actual = runCatching { TokenFactory(value) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `인자로_사칙연산_이외의_기호가_들어오면_들어오면_예외를_발생시킨다`() {
        //given
        val value = "^"
        //when
        val actual = runCatching { TokenFactory(value) }.exceptionOrNull()
        //then
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }
}
