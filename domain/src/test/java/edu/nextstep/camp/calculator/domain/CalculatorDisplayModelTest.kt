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
        assertThat(model.displayText).isEqualTo("1")
    }

    @Test
    fun `put a new operand when previous operand is absent 2`() {
        // given "5 +"
        model.put(5)
        model.put("+")

        // when
        model.put(1)

        // then
        assertThat(model.displayText).isEqualTo("5 + 1")
    }

    @Test
    fun `append the existing operand when previous operand is present`() {
        // given "8"
        model.put(8)

        // when
        model.put(9)

        // then
        assertThat(model.displayText).isEqualTo("89")
    }

    @Test
    fun `do nothing when attempt to put operator on empty state`() {
        // when
        model.put("+")

        // then
        assertThat(model.displayText).isEqualTo("")
    }

    @Test
    fun `replace the existing operator when previous operator is present`() {
        // given
        model.put(1)
        model.put("+")

        // when
        model.put("-")

        // then
        assertThat(model.displayText).isEqualTo("1 -")
    }

    @Test
    fun `do nothing when attempt to delete token on empty state`() {
        // when
        model.delete()

        // then
        assertThat(model.displayText).isEqualTo("")
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

        // then
        assertThat(model.displayText).isEqualTo("32 +")

        // when
        model.delete()

        // then
        assertThat(model.displayText).isEqualTo("32")

        // when
        model.delete()

        // then
        assertThat(model.displayText).isEqualTo("3")

        // when
        model.delete()

        // then
        assertThat(model.displayText).isEqualTo("")
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
        assertThat(model.displayText).isEqualTo("5")
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
