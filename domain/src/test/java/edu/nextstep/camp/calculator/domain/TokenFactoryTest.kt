package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TokenFactoryTest {
    private val factory = TokenFactory()

    @Test
    fun `decimal number string is converted as operand token`() {
        // given
        val piece = "123"

        // when
        val actual = factory.get(piece)

        // then
        assertThat(actual).isInstanceOf(Operand::class.java)
    }

    @Test
    fun `operator string is converted as operator token`() {
        // given
        val piece = "+"

        // when
        val actual = factory.get(piece)

        // then
        assertThat(actual).isInstanceOf(Operator::class.java)
    }

    @Test
    fun `throw when unsupported string is passed`() {
        // given
        val piece = "!@#"

        // when
        val result = runCatching { factory.get(piece) }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(UnsupportedOperatorException::class.java)
    }
}
