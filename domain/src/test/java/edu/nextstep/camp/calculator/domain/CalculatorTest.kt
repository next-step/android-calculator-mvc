package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `tokens can not be empty`() {
        // given
        val tokens = emptyList<Token>()

        // when
        val result = runCatching { calculator.evaluate(tokens) }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `add two numbers`() {
        // given
        val tokens = makeTokens("1 + 2")

        // when
        val actual = calculator.evaluate(tokens)

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `minus two numbers`() {
        // given
        val tokens = makeTokens("1 - 2")

        // when
        val actual = calculator.evaluate(tokens)

        // then
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `multiply two numbers`() {
        // given
        val tokens = makeTokens("2 * 6")

        // when
        val actual = calculator.evaluate(tokens)

        // then
        assertThat(actual).isEqualTo(12)
    }

    @Test
    fun `divide two numbers`() {
        // given
        val tokens = makeTokens("6 / 2")

        // when
        val actual = calculator.evaluate(tokens)

        // then
        assertThat(actual).isEqualTo(3)
    }

    private fun makeTokens(expression: String): List<Token> {
        return expression.split(" ").map { piece ->
            piece.toIntOrNull()
                ?.let { Operand(it) }
                ?: Operator.of(piece)
        }
    }
}
