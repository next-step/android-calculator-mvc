package edu.nextstep.camp.calculator.domain

import org.junit.Assert.assertThrows
import org.junit.Test

/**
 * Created by link.js on 2022. 07. 13..
 */
class CalculatorTest {

    @Test
    fun `덧셈이 잘 동작한다`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `뺄셈이 잘 동작한다`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `곱셈이 잘 동작한다`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `나눗셈이 잘 동작한다`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            Calculator().evaluate(null)
        }
    }

    @Test
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            Calculator().evaluate("")
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `숫자 위치에 숫자가 아닌 경우 IllegalArgumentException throw`() {
        TODO("Not yet implemented")
    }
}