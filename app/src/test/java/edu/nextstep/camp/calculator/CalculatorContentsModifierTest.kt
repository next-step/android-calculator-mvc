package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.Test

class CalculatorContentsModifierTest {

    @Test
    fun appendNumber() {
        //given
        val contents = "1"

        //when
        val result = CalculatorContentsModifier.appendNumber(contents, "2")

        //then
        assertThat(result).isEqualTo("12")
    }

    @Test
    fun appendOperator_whenContentsAreEmpty_resultShouldBeEmpty() {
        //given
        val contents = ""

        //when
        val result = CalculatorContentsModifier.appendOperator(contents, "+")

        //then
        assertThat(result).isEmpty()
    }

    @Test
    fun appendOperator_whenLastContentIsOperator_resultShouldBeNewOperator() {
        //given
        val contents = "1 + "

        //when
        val result = CalculatorContentsModifier.appendOperator(contents, "-")

        //then
        assertThat(result).isEqualTo("1 - ")
    }

    @Test
    fun appendOperator_whenLastContentIsNumber_operatorShouldBeAdded() {
        //given
        val contents = "1 + 3"

        //when
        val result = CalculatorContentsModifier.appendOperator(contents, "-")

        //then
        assertThat(result).isEqualTo("1 + 3 - ")
    }

    @Test
    fun removeLatest_whenContentsAreEmpty_resultShouldBeEmpty() {
        //given
        val contents = ""

        //when
        val result = CalculatorContentsModifier.removeLatest(contents)

        //then
        assertThat(result).isEmpty()
    }

    @Test
    fun removeLatest_whenLastContentIsNumber_numberShouldBeRemoved() {
        //given
        val contents = "1 + 3"

        //when
        val result = CalculatorContentsModifier.removeLatest(contents)

        //then
        assertThat(result).isEqualTo("1 + ")
    }

    @Test
    fun removeLatest_whenLastContentIsOperator_operatorShouldBeRemoved() {
        //given
        val contents = "1 + 3 - "

        //when
        val result = CalculatorContentsModifier.removeLatest(contents)

        //then
        assertThat(result).isEqualTo("1 + 3")
    }

    @Test
    fun calculateContents_WhenLastInputIsEmpty() {
        //given
        val contents = ""

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorContentsModifier.calculateContents(contents)
        }
    }

    @Test
    fun calculateContents_WhenLastInputIsNumber() {
        //given
        val contents = "1 + 3 - 5"

        //when
        val result = CalculatorContentsModifier.calculateContents(contents)

        //then
        assertThat(result).isEqualTo("-1")
    }

    @Test
    fun calculateContents_WhenLastInputIsOperator() {
        //given
        val contents = "1 + 3 - "

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorContentsModifier.calculateContents(contents)
        }
    }
}
