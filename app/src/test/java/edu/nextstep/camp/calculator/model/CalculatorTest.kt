package edu.nextstep.camp.calculator.model

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

        assertTrue(input.isSplitLengthOddNumber())
    }
}