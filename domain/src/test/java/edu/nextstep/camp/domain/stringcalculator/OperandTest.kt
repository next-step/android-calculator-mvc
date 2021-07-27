package edu.nextstep.camp.domain.stringcalculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created By Malibin
 * on 7월 27, 2021
 */

class OperandTest {

    @Test
    fun String_값을_받는_생성자로_인스턴스를_만들_수_있다() {
        // given
        val stringValue = "34"

        // when
        val actualOperand = Operand(stringValue)

        // then
        assertThat(actualOperand.value).isEqualTo(34)
    }

    @Test
    fun 피연산자끼리_덧셈이_가능하다() {
        // given
        val leftOperand = Operand(2)
        val rightOperand = Operand(3)
        val expectedOperand = Operand(5)

        // when
        val actualOperand = leftOperand + rightOperand

        // then
        assertThat(actualOperand).isEqualTo(expectedOperand)
    }

    @Test
    fun 피연산자끼리_뺄셈이_가능하다() {
        // given
        val leftOperand = Operand(2)
        val rightOperand = Operand(3)
        val expectedOperand = Operand(-1)

        // when
        val actualOperand = leftOperand - rightOperand

        // then
        assertThat(actualOperand).isEqualTo(expectedOperand)
    }

    @Test
    fun 피연산자끼리_곱셈이_가능하다() {
        // given
        val leftOperand = Operand(2)
        val rightOperand = Operand(3)
        val expectedOperand = Operand(6)

        // when
        val actualOperand = leftOperand * rightOperand

        // then
        assertThat(actualOperand).isEqualTo(expectedOperand)
    }

    @Test
    fun 피연산자끼리_나눗셈이_가능하다() {
        // given
        val leftOperand = Operand(6)
        val rightOperand = Operand(3)
        val expectedOperand = Operand(2)

        // when
        val actualOperand = leftOperand / rightOperand

        // then
        assertThat(actualOperand).isEqualTo(expectedOperand)
    }
}
