package edu.nextstep.camp.calculator.model

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test


class CalculatorTest {
    @Test
    fun 띄어쓰기문자를_배열로_담을_수_있다(){
        //given
        //when
        var input = Calculator("2 + 3")
        var inputs = input.splitText()

        //then
        assertEquals(inputs.size, 3)
    }

    @Test
    fun 배열에서_인덱스가_짝수인_경우_숫자면_참(){
        var input = Calculator("11 + 3")
        var inputs = input.splitText()

        assertTrue(input.isNumber(inputs[0]))
        assertTrue(input.isNumber(inputs[2]))
    }

    @Test
    fun 배열에서_인덱스가_홀수인_경우_문자이면_참(){
        var input = Calculator("2 + 3")
        var inputs = input.splitText()

        assertFalse(input.isNumber(inputs[1]))
    }

    @Test
    fun 배열_인덱스길이가_홀수이면_참(){
        var input = Calculator("2 + 3 / 2")

        assertTrue(input.isSplitLengthOperator())
    }

    @Test
    fun 배열이_세개일_때_문자열_계산이_참_덧셈(){
        var input = Calculator("2 + 3")
        assertThat(input.calculate(), equalTo(5.0))
    }

    @Test
    fun 배열이_세개일_때_문자열_계산이_참_뺄셈() {
        var input = Calculator("3 - 2")
        assertThat(input.calculate(), equalTo(1.0))
    }

    @Test
    fun 배열이_세개일_때_문자열_계산이_참_곱셈() {
        var input = Calculator("3 * 2")
        assertThat(input.calculate(), equalTo(6.0))
    }

    @Test
    fun 배열이_세개일_때_문자열_계산이_참_나눗셈() {
        var input = Calculator("4 / 2")
        assertThat(input.calculate(), equalTo(2.0))
    }

    @Test
    fun 배열이_다섯개일_때_문자열_계산이_참_덧셈(){
        var input = Calculator("2 + 3 + 3")
        assertThat(input.calculate(), equalTo(8.0))
    }

    @Test
    fun 배열이_다섯개일_때_문자열_계산이_참_뺄셈() {
        var input = Calculator("5 - 2 - 1")
        assertThat(input.calculate(), equalTo(2.0))
    }

    @Test
    fun 배열이_다섯개일_때_문자열_계산이_참_곱셈() {
        var input = Calculator("3 * 2 * 2")
        assertThat(input.calculate(), equalTo(12.0))
    }

    @Test
    fun 배열이_다섯개일_때_문자열_계산이_참_나눗셈() {
        var input = Calculator("6 / 2 / 2")
        assertThat(input.calculate(), equalTo(1.5))
    }

    @Test
    fun 사칙연산() {
        var input = Calculator("2 + 3 * 4 / 2")
        assertThat(input.calculate(), equalTo(10.0))
    }
}