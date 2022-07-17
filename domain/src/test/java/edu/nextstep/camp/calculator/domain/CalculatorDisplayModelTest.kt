package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorDisplayModelTest {
    private val model = CalculatorDisplayModel()

    @Test
    fun `put a new operand when previous operand is absent`() {
        // when
        model.put(1)

        // then
        val expected = listOf(
            Operand(1)
        )
        assertThat(model.tokens).isEqualTo(expected)
    }

    @Test
    fun `put a new operand when previous operand is absent 2`() {
        // given "5 +"
        model.put(5)
        model.put("+")

        // when
        model.put(1)

        // then
        val expected = listOf(
            Operand(5),
            Operator.Plus,
            Operand(1)
        )
        assertThat(model.tokens).isEqualTo(expected)
    }

    @Test
    fun `append the existing operand when previous operand is present`() {
        // given "8"
        model.put(8)

        // when
        model.put(9)

        // then
        val expected = listOf(
            Operand(89),
        )
        assertThat(model.tokens).isEqualTo(expected)
    }

    @Test
    fun `do nothing when attempt to put operator on empty state`() {
        // when
        model.put("+")

        // then
        assertThat(model.tokens).isEmpty()
    }

    @Test
    fun `replace the existing operator when previous operator is present`() {
        // given
        model.put(1)
        model.put("+")

        // when
        model.put("-")

        // then
        val expected = listOf(
            Operand(1),
            Operator.Minus
        )
        assertThat(model.tokens).isEqualTo(expected)
    }

    @Test
    fun `do nothing when attempt to delete token on empty state`() {
        // when
        model.delete()

        // then
        assertThat(model.tokens).isEmpty()
    }

    @Test
    fun `delete the most recent token when attempt to delete token`() {
        // given
        model.put(3)
        model.put(2)
        model.put("+")
        model.put(1)

        // when
        model.delete()

        // then "32 +"
        var expected = listOf(
            Operand(32),
            Operator.Plus
        )
        assertThat(model.tokens).isEqualTo(expected)

        // when
        model.delete()

        // then "32"
        expected = listOf(
            Operand(32),
        )
        assertThat(model.tokens).isEqualTo(expected)

        // when
        model.delete()

        // then "3"
        expected = listOf(
            Operand(3),
        )
        assertThat(model.tokens).isEqualTo(expected)

        // when
        model.delete()

        // then
        assertThat(model.tokens).isEmpty()
    }

    @Test
    fun `calculate`() {
        // given
        model.put(3)
        model.put("+")
        model.put(2)

        // when
        model.calculate()

        // then
        val expected = listOf(
            Operand(5),
        )
        assertThat(model.tokens).isEqualTo(expected)
    }

    @Test
    fun `throw when attempt to calculate on invalid state`() {
        // given
        model.put(3)
        model.put("+")

        // when
        val result = runCatching { model.calculate() }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(ExpressionParsingException::class.java)
    }

}
