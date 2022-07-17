package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `put a new operand when previous operand is absent`() {
        // when
        calculator.put(1)

        // then
        val expected = listOf(
            Operand(1)
        )
        assertThat(calculator.tokens).isEqualTo(expected)
    }

    @Test
    fun `put a new operand when previous operand is absent 2`() {
        // given "5 +"
        calculator.put(5)
        calculator.put("+")

        // when
        calculator.put(1)

        // then
        val expected = listOf(
            Operand(5),
            Operator.Plus,
            Operand(1)
        )
        assertThat(calculator.tokens).isEqualTo(expected)
    }

    @Test
    fun `append the existing operand when previous operand is present`() {
        // given "8"
        calculator.put(8)

        // when
        calculator.put(9)

        // then
        val expected = listOf(
            Operand(89),
        )
        assertThat(calculator.tokens).isEqualTo(expected)
    }

    @Test
    fun `do nothing when attempt to put operator on empty state`() {
        // when
        calculator.put("+")

        // then
        assertThat(calculator.tokens).isEmpty()
    }

    @Test
    fun `replace the existing operator when previous operator is present`() {
        // given
        calculator.put(1)
        calculator.put("+")

        // when
        calculator.put("-")

        // then
        val expected = listOf(
            Operand(1),
            Operator.Minus
        )
        assertThat(calculator.tokens).isEqualTo(expected)
    }

    @Test
    fun `do nothing when attempt to delete token on empty state`() {
        // when
        calculator.delete()

        // then
        assertThat(calculator.tokens).isEmpty()
    }

    @Test
    fun `delete the most recent token when attempt to delete token`() {
        // given
        calculator.put(3)
        calculator.put(2)
        calculator.put("+")
        calculator.put(1)

        // when
        calculator.delete()

        // then "32 +"
        var expected = listOf(
            Operand(32),
            Operator.Plus
        )
        assertThat(calculator.tokens).isEqualTo(expected)

        // when
        calculator.delete()

        // then "32"
        expected = listOf(
            Operand(32),
        )
        assertThat(calculator.tokens).isEqualTo(expected)

        // when
        calculator.delete()

        // then "3"
        expected = listOf(
            Operand(3),
        )
        assertThat(calculator.tokens).isEqualTo(expected)

        // when
        calculator.delete()

        // then
        assertThat(calculator.tokens).isEmpty()
    }

    @Test
    fun `calculate`() {
        // given
        calculator.put(3)
        calculator.put("+")
        calculator.put(2)

        // when
        calculator.calculate()

        // then
        val expected = listOf(
            Operand(5),
        )
        assertThat(calculator.tokens).isEqualTo(expected)
    }

    @Test
    fun `throw when attempt to calculate on invalid state`() {
        // given
        calculator.put(3)
        calculator.put("+")

        // when
        val result = runCatching { calculator.calculate() }

        // then
        assertThat(result.exceptionOrNull()).isInstanceOf(ExpressionParsingException::class.java)
    }

}
