package edu.nextstep.camp.calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Created by link.js on 2022. 07. 13..
 */

class CalculatorTest {
    private val calculator = Calculator(' ')

    @Test
    fun `"2 + 5" 는 7 이다`() {
        calculator.addOperand("2")
        calculator.addOperator("+")
        calculator.addOperand("5")
        calculator.evaluate()
        assertEquals(calculator.expression, "7")
    }

    @Test
    fun `"6 나누기 3" 는 2 이다`() {
        calculator.addOperand("6")
        calculator.addOperator("/")
        calculator.addOperand("3")
        calculator.evaluate()
        assertEquals(calculator.expression, "2")
    }

    @Test
    fun `"4 * 3" 는 12 이다`() {
        calculator.addOperand("4")
        calculator.addOperator("*")
        calculator.addOperand("3")
        calculator.evaluate()
        assertEquals(calculator.expression, "12")
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            calculator.addOperand("3")
            calculator.addOperator("]")
            calculator.addOperand("3")
            calculator.evaluate()
        }
    }

    @Test
    fun `0으로 나눌 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            calculator.addOperand("3")
            calculator.addOperator("/")
            calculator.addOperand("0")
            calculator.evaluate()
        }
    }

    @Test
    fun `5를 넣으면 식에 5가 잘 저장 된다`() {
        calculator.addOperand("5")
        assertEquals(calculator.expression, "5")
    }

    @Test
    fun `"5 + 3"에서 delete를 누르면 "5 +"만 남는다`() {
        calculator.addOperand("5")
        calculator.addOperator("+")
        calculator.addOperand("3")
        calculator.delete()
        assertEquals(calculator.expression, "5 +")
    }
}