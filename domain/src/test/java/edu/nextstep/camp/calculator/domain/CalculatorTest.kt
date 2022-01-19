package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.Test

class CalculatorTest {

    @Test
    fun calculatePlus() {
        val result = Calculator.calculateContents("1 + 2 + 3")
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun calculateMinus() {
        val result = Calculator.calculateContents("4 - 5 - 6")
        assertThat(result).isEqualTo(-7)
    }

    @Test
    fun calculateMultiplication() {
        val result = Calculator.calculateContents("7 * 8 * 9")
        assertThat(result).isEqualTo(504)
    }

    @Test
    fun calculateDivision() {
        val result = Calculator.calculateContents("10 / 8 / 5")
        assertThat(result).isEqualTo(0.25)
    }

    @Test
    fun calculateNull() {
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateContents("")
        }
    }

    @Test
    fun calculateNotProperOperation() {
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateContents("1 # 4 @ 7")
        }
    }

    @Test
    fun calculateAllTheOperation() {
        val result = Calculator.calculateContents("1 + 2 * 4 / 6 - 5")
        assertThat(result).isEqualTo(-3)
    }
}
