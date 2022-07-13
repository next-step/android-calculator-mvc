package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionTest {
    lateinit var expression: Expression

    @Test
    fun `evaluate two value expressions`() {
        // given
        val a = ValueNode(1)
        val b = ValueNode(2)
        val op = "+"
        expression = ExpressionNode(a, b, op)

        // when
        val actual = expression.evaluate()

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `expression is composable`() {
        // given
        // ((2 + (3 * 4)) / 2)
        expression = ExpressionNode(
            left = ExpressionNode(
                left = ValueNode(2),
                right = ExpressionNode(
                    left = ValueNode(3),
                    right = ValueNode(4),
                    op = "*"
                ),
                op = "+"
            ),
            right = ValueNode(2),
            op = "/"
        )

        // when
        val actual = expression.evaluate()

        // then
        assertThat(actual).isEqualTo(7)
    }
}
