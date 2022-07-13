package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ParserTest {
    private val parser = Parser()

    @Test
    fun `throw when token ends with operator`() {
        // given
        val tokens = listOf(Number(1), Operator("+"))

        // when
        val result = runCatching { parser.parse(tokens) }

        // then
        assertThat(result.exceptionOrNull())
            .isInstanceOf(ExpressionParsingException::class.java)
    }

    @Test
    fun `throw when token starts with operator`() {
        // given
        val tokens = listOf(Operator("+"), Number(1))

        // when
        val result = runCatching { parser.parse(tokens) }

        // then
        assertThat(result.exceptionOrNull())
            .isInstanceOf(ExpressionParsingException::class.java)
    }

    @Test
    fun `return expression when token is valid`() {
        // given
        val tokens = listOf(Number(1), Operator("+"), Number(3))

        // when
        val actual = parser.parse(tokens)

        // then
        val expected = ExpressionNode(
            left = ValueNode(1),
            right = ValueNode(3),
            op = "+"
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `ignore operator precedence`() {
        // given "2 + 3 * 4 / 2"
        val tokens = listOf(
            Number(2),
            Operator("+"),
            Number(3),
            Operator("*"),
            Number(4),
            Operator("/"),
            Number(2),
        )

        // when
        val actual = parser.parse(tokens)

        // then "(((2 + 3) * 4) / 2)"
        val expected = ExpressionNode(
            left = ExpressionNode(
                left = ExpressionNode(
                    left = ValueNode(2),
                    right = ValueNode(3),
                    op = "+"
                ),
                right = ValueNode(4),
                op = "*"
            ),
            right = ValueNode(2),
            op = "/",
        )
        assertThat(actual).isEqualTo(expected)
    }
}
