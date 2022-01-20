package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.Test

class CalculatorTest {

    @Test
    fun calculatePlus() {
        //given
        val contents = "1 + 2 + 3"

        //when
        val result = Calculator.calculateContents(contents)

        //then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun calculateMinus() {
        //given
        val contents = "4 - 5 - 6"

        //when
        val result = Calculator.calculateContents(contents)

        //then
        assertThat(result).isEqualTo(-7)
    }

    @Test
    fun calculateMultiplication() {
        //given
        val contents = "7 * 8 * 9"

        //when
        val result = Calculator.calculateContents(contents)

        //then
        assertThat(result).isEqualTo(504)
    }

    @Test
    fun calculateDivision() {
        //given
        val contents = "10 / 8 / 5"

        //when
        val result = Calculator.calculateContents(contents)

        //then
        assertThat(result).isEqualTo(0.25)
    }

    @Test
    fun calculateNull() {
        //given
        val contents = ""

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateContents(contents)
        }
    }

    @Test
    fun calculateNotProperOperation() {
        //given
        val contents = "1 # 4 @ 7"

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateContents(contents)
        }
    }

    @Test
    fun calculateAllTheOperation() {
        //given
        val contents = "1 + 2 * 4 / 6 - 5"

        //when
        val result = Calculator.calculateContents(contents)

        //then
        assertThat(result).isEqualTo(-3)
    }
}
