package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class ExpressionTest {
    private lateinit var expression: Expression

    @Before
    fun setUp() {
        expression = Expression()
    }

    @Test
    fun 사용자가_입력한대로_더하기_수식을_넣을때_계산할_준비가_되어있는_경우() {
        //given
        val input = "10 + 2 + 3"
        expression.setStackForCalculating(input)

        //when
        val actual = expression.isReadyForCalculating()

        //then
        assertThat(actual).isEqualTo(true)
    }

    @Test
    fun 사용자가_수식을_입력했을_때_현재_가장_위에있는_값() {
        //given
        val input = "10 - 2 - 3"
        expression.setStackForCalculating(input)

        //when
        val actual = expression.getCurrentValue()

        //then
        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun 사용자가_수식을_입력했을_때_현재_Operator_값() {
        //given
        val input = "10 * 2 * 3"
        expression.setStackForCalculating(input)
        expression.getOperand()

        //when
        val actual = expression.getOperator()

        //then
        assertThat(actual).isEqualTo("*")
    }

    @Test
    fun 사용자가_수식을_입력했을_떄_현재_Operand_경우() {
        //given
        val input = "10 / 2 / 3"
        expression.setStackForCalculating(input)

        //when
        val actual = expression.getOperand()

        //then
        assertThat(actual).isEqualTo(10)
    }
}