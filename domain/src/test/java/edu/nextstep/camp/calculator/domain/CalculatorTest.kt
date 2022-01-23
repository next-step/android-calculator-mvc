package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.Test

class CalculatorTest {

    @Test
    fun calculatePlus() {
        //given
        val formula = "1 + 2 + 3"

        //when
        val result = Calculator.calculateFormula(formula)

        //then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun calculateMinus() {
        //given
        val formula = "4 - 5 - 6"

        //when
        val result = Calculator.calculateFormula(formula)

        //then
        assertThat(result).isEqualTo(-7)
    }

    @Test
    fun calculateMultiplication() {
        //given
        val formula = "7 × 8 × 9"

        //when
        val result = Calculator.calculateFormula(formula)

        //then
        assertThat(result).isEqualTo(504)
    }

    @Test
    fun calculateDivision() {
        //given
        val formula = "10 ÷ 8 ÷ 5"

        //when
        val result = Calculator.calculateFormula(formula)

        //then
        assertThat(result).isEqualTo(0.25)
    }

    @Test
    fun calculateNull() {
        //given
        val formula = ""

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateFormula(formula)
        }
    }

    @Test
    fun calculateNotProperOperation() {
        //given
        val formula = "1 # 4 @ 7"

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateFormula(formula)
        }
    }

    @Test
    fun calculateAllTheOperation() {
        //given
        val formula = "1 + 2 × 4 ÷ 6 - 5"

        //when
        val result = Calculator.calculateFormula(formula)

        //then
        assertThat(result).isEqualTo(-3)
    }
}
