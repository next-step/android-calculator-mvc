package edu.nextstep.camp.calculator.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

/**
 * Created by link.js on 2022. 07. 13..
 */
class CalculatorTest {

    @Test
    fun `덧셈이 잘 동작한다`() {
        val calculator = Calculator()
        assertEquals(calculator.evaluate("2 + 3"), 5)
    }

    @Test
    fun `뺄셈이 잘 동작한다`() {
        val calculator = Calculator()
        assertEquals(calculator.evaluate("4 - 3"), 1)
    }

    @Test
    fun `곱셈이 잘 동작한다`() {
        val calculator = Calculator()
        assertEquals(calculator.evaluate("2 * 3"), 6)
    }

    @Test
    fun `나눗셈이 잘 동작한다`() {
        val calculator = Calculator()
        assertEquals(calculator.evaluate("4 / 2"), 2)
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
        assertThrows(IllegalArgumentException::class.java) {
            Calculator().evaluate("2 [ 3")
        }
    }

    @Test
    fun `숫자 위치에 숫자가 아닌 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            Calculator().evaluate("2 3 3")
        }
    }

    @Test
    fun `Operator는 연산자를 잘 찾아내는가`() {
        assertEquals(Operator.of("+"), Operator.PLUS)
        assertEquals(Operator.of("-"), Operator.MINUS)
        assertEquals(Operator.of("/"), Operator.DIVISION)
        assertEquals(Operator.of("*"), Operator.MULTIPLY)
    }

    @Test
    fun `0으로 나눌 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            Calculator().evaluate("2 / 0")
        }
    }
}