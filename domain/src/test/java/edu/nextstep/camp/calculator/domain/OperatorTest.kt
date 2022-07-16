package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class OperatorTest {
    @Test
    fun `plus operator plus two numbers`() {
        // given
        val op = Operator.Plus

        // when
        val actual = op.operate(1, 2)

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `minus operator plus two numbers`() {
        // given
        val op = Operator.Minus

        // when
        val actual = op.operate(1,2)

        // then
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `multiply operator plus two numbers`() {
        // given
        val op = Operator.Multiply

        // when
        val actual = op.operate(2, 3)

        // then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `divide operator plus two numbers`() {
        // given
        val op = Operator.Divide

        // when
        val actual = op.operate(6,3)

        // then
        assertThat(actual).isEqualTo(2)
    }
}