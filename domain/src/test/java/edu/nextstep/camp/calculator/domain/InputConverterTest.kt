package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class InputConverterTest {

    private val inputConverter = InputConverter()

    @Test
    fun 피연산자를_리스트에_추가할_수_있다() {
        //when
        inputConverter.add("1")
        val actual = inputConverter.token
        //then
        val expected = listOf(Operand(1))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun 피연산자를_연속으로_추가하면_숫자_두개가_합쳐진다() {
        //when
        inputConverter.add("1")
        inputConverter.add("2")
        val actual = inputConverter.token
        //then
        val expected = listOf(Operand(12))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun 입력된_피연산자가_없을_때_연산자를_입력하면_빈_값을_반환한다() {
        //when
        inputConverter.add("+")
        val actual = inputConverter.token
        //then
        val expected = emptyList<Token>()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun 연산자를_연속해서_입력하면_마지막_연산자를_최종적으로_반환한다() {
        //given
        inputConverter.add("1")
        inputConverter.add("2")
        inputConverter.add("+")
        //when
        inputConverter.add("-")
        inputConverter.add("×")
        val actual = inputConverter.token
        //then
        val expected = listOf(Operand(12), Operator.MULTIPLY)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun 입력된_수식이_없을_때_삭제를_하면_아무런_변화가_없다() {
        //when
        inputConverter.delete()
        inputConverter.delete()
        val actual = inputConverter.token
        //then
        val expected = emptyList<Token>()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun 입력된_수식에_마지막이_연산자일_경우_삭제하면_연산자를_삭제한다() {
        //given
        inputConverter.add("2")
        inputConverter.add("+")
        //when
        inputConverter.delete()
        val actual = inputConverter.token
        //then
        val expected = listOf(Operand(2))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun 입력된_수식에_마지막이_10미만의_피연산자일_경우_삭제하면_피연산자를_삭제한다() {
        //given
        inputConverter.add("2")
        inputConverter.add("+")
        inputConverter.add("9")
        //when
        inputConverter.delete()
        val actual = inputConverter.token
        //then
        val expected = listOf(Operand(2), Operator.PLUS)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun 입력된_수식에_마지막이_10이상의_피연산자일_경우_삭제하면_피연산자의_일의자리를_삭제한다() {
        //given
        inputConverter.add("2")
        inputConverter.add("1")
        //when
        inputConverter.delete()
        val actual = inputConverter.token
        //then
        val expected = listOf(Operand(2))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun 리스트에_모든_토큰을_제거하고_새로운_값을_추가한다() {
        //given
        inputConverter.add("2")
        inputConverter.add("1")
        inputConverter.add("+")
        inputConverter.add("9")
        //when
        inputConverter.clearAndAddResult(5)
        val actual = inputConverter.token
        //then
        val expected = listOf(Operand(5))
        assertThat(actual).isEqualTo(expected)
    }
}
