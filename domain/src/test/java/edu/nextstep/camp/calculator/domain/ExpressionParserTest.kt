package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import org.junit.Before
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Before
    fun setUp() {
        parser = ExpressionParser()
    }

    @Test
    fun `공백으로 구분된 올바른 수식을 파싱한다`() {
        // when
        val actual = parser.parse("1 + 2 / 3")

        // then
        assertThat(actual).isEqualTo(Expression(listOf(1, 2, 3), listOf(Symbol.Sign.PLUS, Symbol.Sign.DIVISION)))
    }

    @Test
    fun `공백으로 구분되지 않은 올바른 수식을 파싱한다`() {
        // when
        val actual = parser.parse("1+2/3")

        // then
        assertThat(actual).isEqualTo(Expression(listOf(1, 2, 3), listOf(Symbol.Sign.PLUS, Symbol.Sign.DIVISION)))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `기호가 연속으로 등장하면 오류를 반환한다`() {
        // when
        parser.parse("1++2/3")
    }

    @Test
    fun `공백으로 구분된 숫자가 연속으로 등장하면 오류를 반환한다`() {
        TODO("Not yet implemented")
    }
}
