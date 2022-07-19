package edu.nextstep.camp.calculator.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Created by link.js on 2022. 07. 19..
 */
class ExpressionTest {
    private val expression = Expression(' ')

    @Test
    fun `"2 + 5" 는 7 이다`() {
        expression.addOperand("2")
        expression.addOperator("+")
        expression.addOperand("5")
        expression.evaluate()
        Assertions.assertEquals(expression.expression, "7")
    }

    @Test
    fun `"6 나누기 3" 는 2 이다`() {
        expression.addOperand("6")
        expression.addOperator("/")
        expression.addOperand("3")
        expression.evaluate()
        Assertions.assertEquals(expression.expression, "2")
    }

    @Test
    fun `"4 * 3" 는 12 이다`() {
        expression.addOperand("4")
        expression.addOperator("*")
        expression.addOperand("3")
        expression.evaluate()
        Assertions.assertEquals(expression.expression, "12")
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            expression.addOperand("3")
            expression.addOperator("]")
            expression.addOperand("3")
            expression.evaluate()
        }
    }

    @Test
    fun `0으로 나눌 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            expression.addOperand("3")
            expression.addOperator("/")
            expression.addOperand("0")
            expression.evaluate()
        }
    }

    @Test
    fun `5를 넣으면 식에 5가 잘 저장 된다`() {
        expression.addOperand("5")
        Assertions.assertEquals(expression.expression, "5")
    }

    @Test
    fun `"5 + 3"에서 delete를 누르면 "5 +"만 남는다`() {
        expression.addOperand("5")
        expression.addOperator("+")
        expression.addOperand("3")
        expression.delete()
        Assertions.assertEquals(expression.expression, "5 +")
    }
}