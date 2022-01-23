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

    @Test
    fun isRoundedNumber_whenParamIsRoundedNumber_shouldReturnTrue() {
        //given
        val content = -12.0

        //when
        val result = Calculator.isRoundedNumber(content)

        //then
        assertThat(result).isTrue()
    }

    @Test
    fun isRoundedNumber_whenParamIsNotRoundedNumber_shouldReturnFalse() {
        //given
        val content = 12.5

        //when
        val result = Calculator.isRoundedNumber(content)

        //then
        assertThat(result).isFalse()
    }

    @Test
    fun isNumber_whenParamIsNumber_shouldReturnTrue() {
        //given
        val content = "1"

        //when
        val result = Calculator.isNumber(content)

        //then
        assertThat(result).isTrue()
    }

    @Test
    fun isNumber_whenParamIsNotNumber_shouldReturnFalse() {
        //given
        val content = "+"

        //when
        val result = Calculator.isNumber(content)

        //then
        assertThat(result).isFalse()
    }
}
