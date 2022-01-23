package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.Test

class CalculatorFormulaModifierTest {

    @Test
    fun appendOperand_thenOperandShouldBeAdded() {
        //given
        val formula = "1"

        //when
        val result = CalculatorFormulaModifier.appendOperand(formula, "2")

        //then
        assertThat(result).isEqualTo("12")
    }

    @Test
    fun appendOperator_whenFormulaIsEmpty_resultShouldBeEmpty() {
        //given
        val formula = ""

        //when
        val result = CalculatorFormulaModifier.appendOperator(formula, "+")

        //then
        assertThat(result).isEmpty()
    }

    @Test
    fun appendOperator_whenLastContentIsOperator_resultShouldBeNewOperator() {
        //given
        val formula = "1 + "

        //when
        val result = CalculatorFormulaModifier.appendOperator(formula, "-")

        //then
        assertThat(result).isEqualTo("1 - ")
    }

    @Test
    fun appendOperator_whenLastContentIsNumber_operatorShouldBeAdded() {
        //given
        val formula = "1 + 3"

        //when
        val result = CalculatorFormulaModifier.appendOperator(formula, "-")

        //then
        assertThat(result).isEqualTo("1 + 3 - ")
    }

    @Test
    fun removeLatest_whenFormulaIsEmpty_resultShouldBeEmpty() {
        //given
        val formula = ""

        //when
        val result = CalculatorFormulaModifier.removeLatest(formula)

        //then
        assertThat(result).isEmpty()
    }

    @Test
    fun removeLatest_whenLastContentIsOperand_operandShouldBeRemoved() {
        //given
        val formula = "1 + 3"

        //when
        val result = CalculatorFormulaModifier.removeLatest(formula)

        //then
        assertThat(result).isEqualTo("1 + ")
    }

    @Test
    fun removeLatest_whenLastContentIsOperator_operatorShouldBeRemoved() {
        //given
        val formula = "1 + 3 - "

        //when
        val result = CalculatorFormulaModifier.removeLatest(formula)

        //then
        assertThat(result).isEqualTo("1 + 3")
    }

    @Test
    fun calculateFormula_WhenLastInputIsEmpty() {
        //given
        val formula = ""

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorFormulaModifier.calculateFormula(formula)
        }
    }

    @Test
    fun calculateFormula_WhenLastInputIsOperand() {
        //given
        val formula = "1 + 3 - 5"

        //when
        val result = CalculatorFormulaModifier.calculateFormula(formula)

        //then
        assertThat(result).isEqualTo("-1")
    }

    @Test
    fun calculateFormula_WhenLastInputIsOperator() {
        //given
        val formula = "1 + 3 - "

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorFormulaModifier.calculateFormula(formula)
        }
    }
}
