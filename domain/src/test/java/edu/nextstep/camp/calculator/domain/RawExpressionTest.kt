package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.*
import org.junit.Before
import org.junit.Test

class RawExpressionTest {

    private lateinit var builder: RawExpression.Builder

    @Before
    fun setUp() {
        builder = RawExpression.Builder()
    }

    @Test
    fun `1을 입력하고 빌드하면 1이 반환된다`() {
        // when
        val actual = builder
            .enterNumber(RawExpression.Number.ONE)
            .build()

        // then
        assertThat(actual).isEqualTo("1")
    }

    @Test
    fun `1이 입력된 상태에서 더하기를 입력하고 빌드하면 1 더하기가 반환된다`() {
        // given
        builder.enterNumber(RawExpression.Number.ONE)

        // when
        val actual = builder
            .enterSign(RawExpression.Sign.PLUS)
            .build()

        // then
        assertThat(actual).isEqualTo("1 +")
    }

    @Test
    fun `아무것도 입력되지 않은 상태에서 더하기를 입력하고 빌드하면 빈 문자열이 반환된다`() {
        // when
        val actual = builder
            .enterSign(RawExpression.Sign.PLUS)
            .build()

        // then
        assertThat(actual).isEqualTo("")
    }

    @Test
    fun `1 더하기가 입력된 상태에서 빼기를 입력하고 빌드하면 1 빼기가 반환된다`() {
        // given
        builder
            .enterNumber(RawExpression.Number.ONE)
            .enterSign(RawExpression.Sign.PLUS)

        // when
        val actual = builder
            .enterSign(RawExpression.Sign.MINUS)
            .build()

        // then
        assertThat(actual).isEqualTo("1 -")
    }

    @Test
    fun `1 더하기가 입력된 상태에서 1을 입력하고 빌드하면 1 더하기 1이 반환된다`() {
        // given
        builder
            .enterNumber(RawExpression.Number.ONE)
            .enterSign(RawExpression.Sign.PLUS)

        // when
        val actual = builder
            .enterNumber(RawExpression.Number.ONE)
            .build()

        // then
        assertThat(actual).isEqualTo("1 + 1")
    }

    @Test
    fun `1이 입력된 상태에서 1을 입력하고 빌드하면 11이 반환된다`() {
        // given
        builder.enterNumber(RawExpression.Number.ONE)

        // when
        val actual = builder
            .enterNumber(RawExpression.Number.ONE)
            .build()

        // then
        assertThat(actual).isEqualTo("11")
    }

    @Test
    fun `1 더하기가 입력된 상태에서 지우기를 하고 빌드하면 1이 반환된다`() {
        // given
        builder
            .enterNumber(RawExpression.Number.ONE)
            .enterSign(RawExpression.Sign.PLUS)

        // when
        val actual = builder
            .remove()
            .build()

        // then
        assertThat(actual).isEqualTo("1")
    }
}
