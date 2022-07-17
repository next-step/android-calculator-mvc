package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TokenizerTest {
    private val tokenizer = Tokenizer()

    @Test
    fun `tokenizer can parse expression`() {
        // given
        val expression = "1+3*4/6"

        // when
        val result = tokenizer.tokenize(expression)

        // then
        assertThat(result).hasSize(7)

        val expected = listOf(
            Operand(1),
            Operator.Plus,
            Operand(3),
            Operator.Multiply,
            Operand(4),
            Operator.Divide,
            Operand(6),
        )
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `only arithmetic operator is supported`() {
        // +, -, *, /
        // given
        val expression = "5 ** 5"

        // when
        val result = tokenizer.tokenize(expression)

        // then
        val expected = listOf(
            Operand(5),
            Operator.Multiply,
            Operator.Multiply,
            Operand(5),
        )
        assertThat(result).isEqualTo(expected)
    }

}