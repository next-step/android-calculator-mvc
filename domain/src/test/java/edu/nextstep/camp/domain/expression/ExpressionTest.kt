package edu.nextstep.camp.domain.expression

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

private const val JOIN_DELIMITER = " "

class ExpressionTest {

    private lateinit var expression: Expression

    @BeforeEach
    internal fun setUp() {
        expression = Expression(JOIN_DELIMITER)
    }

    @Test
    fun testGenerate() {
        //given
        expression.append("1")
        expression.append("+")
        expression.append("3")

        //when
        val actual = expression.generate()
        val expected = "1 + 3"

        //then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun testAppendWithEmptyList() {
        //given
        val expected: MutableList<String> = mutableListOf()
        expected.add("1")

        //when
        expression.append("1")
        val actual = expression.symbols

        //then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun testAppendWithDigitEndingList() {
        //given
        val expected: MutableList<String> = mutableListOf()
        expected.add("12")

        //when
        expression.append("1")
        expression.append("2")
        val actual = expression.symbols

        //then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun testDelete() {
        //given
        val expected: MutableList<String> = mutableListOf()
        expression.append("1")

        //when
        expression.delete()
        val actual = expression.symbols
        expected.removeLastOrNull()

        //then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun testUpdate() {
        //given
        val expected: MutableList<String> = mutableListOf()
        expected.add("4")
        expression.append("1")
        expression.append("+")
        expression.append("3")

        //when
        expression.update("4")
        val actual = expression.symbols

        //then
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}