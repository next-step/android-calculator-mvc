package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TokenizerTest {
    private val tokenizer = Tokenizer()

    @Test
    fun `tokenizer can parse expression`() {
        // given
        val expression = "1 + 3 * 4 / 6"

        // when
        val result = tokenizer.tokenize(expression)

        // then
        assertThat(result).hasSize(7)

        val expected = listOf(
            Operand(1),
            Operator("+"),
            Operand(3),
            Operator("*"),
            Operand(4),
            Operator("/"),
            Operand(6),
        )
        assertThat(result).isEqualTo(expected)
    }


    @Test
    fun `tokenizer only can parse divided by space expression`() {
        // given
        val expression = "1+5*3"

        // when
        val result = runCatching { tokenizer.tokenize(expression) }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(InvalidTokenException::class.java)
    }

    @Test
    fun `only arithmetic operator is supported`() {
        // +, -, *, /
        // given
        val expression = "5 ** 5"

        // when
        val result = runCatching { tokenizer.tokenize(expression) }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(UnsupportedOperatorException::class.java)
    }

}