package edu.nextstep.camp.calculator.model

import org.assertj.core.api.Assertions
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test


class CalculatorTest {
    @Test
    fun `문자열계산식 없을 때 예외발생`(){
        Assertions.assertThatThrownBy { Calculator("").splitText() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("문자열 계산을 할 수 없습니다.")
    }

    @Test
    fun `문자열계산식 없을 때 숫자가 없을 때 예외발생`(){
        Assertions.assertThatThrownBy { Calculator("? + 2").splitText() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자를 입력해주세요.")
    }

    @Test
    fun `문자열계산식 없을 때 연산자가 아닐 때 예외발생`(){
        Assertions.assertThatThrownBy { Calculator("2 # 4").splitText() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("올바른 연산자 부호를 입력해주세요.")
    }

    @Test
    fun `띄어쓰기문자를 배열로 담을 수 있다`(){
        //given
        //when
        var input = Calculator("2 + 3")
        var inputs = input.splitText()

        //then
        assertEquals(inputs.size, 3)
    }

    @Test
    fun `배열에서 인덱스가 짝수인 경우 숫자면 참`(){
        var input = Calculator("11 + 3")
        var inputs = input.splitText()

        assertTrue(input.isNumber(inputs[0]))
        assertTrue(input.isNumber(inputs[2]))
    }

    @Test
    fun `배열에서 인덱스가 홀수인 경우 문자이면 참`(){
        var input = Calculator("2 + 3")
        var inputs = input.splitText()

        assertFalse(input.isNumber(inputs[1]))
    }

    @Test
    fun `배열 인덱스길이가 홀수이면 참`(){
        var input = Calculator("2 + 3 / 2")

        assertTrue(input.isSplitLengthOperator())
    }

    @Test
    fun `배열이 세개일 때 문자열 계산이 참 덧셈`(){
        var input = Calculator("2 + 3")
        assertThat(input.calculate(), equalTo(5.0))
    }

    @Test
    fun `배열이 세개일 때 문자열 계산이 참 뺄셈`() {
        var input = Calculator("3 - 2")
        assertThat(input.calculate(), equalTo(1.0))
    }

    @Test
    fun `배열이 세개일 때 문자열 계산이 참 곱셈`() {
        var input = Calculator("3 * 2")
        assertThat(input.calculate(), equalTo(6.0))
    }

    @Test
    fun `배열이 세개일 때 문자열 계산이 참 나눗셈`() {
        var input = Calculator("4 / 2")
        assertThat(input.calculate(), equalTo(2.0))
    }

    @Test
    fun `배열이 다섯개일 때 문자열 계산이 참 덧셈`(){
        var input = Calculator("2 + 3 + 3")
        assertThat(input.calculate(), equalTo(8.0))
    }

    @Test
    fun `배열이 다섯개일 때 문자열 계산이 참 뺄셈`() {
        var input = Calculator("5 - 2 - 1")
        assertThat(input.calculate(), equalTo(2.0))
    }

    @Test
    fun `배열이 다섯개일 때 문자열 계산이 참 곱셈`() {
        var input = Calculator("3 * 2 * 2")
        assertThat(input.calculate(), equalTo(12.0))
    }

    @Test
    fun `배열이 다섯개일 때 문자열 계산이 참 나눗셈`() {
        var input = Calculator("6 / 2 / 2")
        assertThat(input.calculate(), equalTo(1.5))
    }

    @Test
    fun `사칙연산`() {
        var input = Calculator("2 + 3 * 4 / 2")
        assertThat(input.calculate(), equalTo(10.0))
    }
}