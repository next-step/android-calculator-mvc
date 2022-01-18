package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.Assertions
import org.junit.Test

class CalculatorTest {

    @Test
    fun test_calculate_plus() {
        val result = Calculator.calculateContents("1 + 2 + 3")
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun test_calculate_minus() {
        val result = Calculator.calculateContents("4 - 5 - 6")
        assertThat(result).isEqualTo(-7)
    }

    @Test
    fun test_calculate_multiplication() {
        val result = Calculator.calculateContents("7 * 8 * 9")
        assertThat(result).isEqualTo(504)
    }

    @Test
    fun test_calculate_division() {
        val result = Calculator.calculateContents("10 / 8 / 5")
        assertThat(result).isEqualTo(0.25)
    }

    @Test
    fun test_calculate_null() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateContents("")
        }
    }

    @Test
    fun test_calculate_not_proper_operation() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateContents("1 # 4 @ 7")
        }
    }

    @Test
    fun test_calculate_all_the_operation() {
        val result = Calculator.calculateContents("1 + 2 * 4 / 6 - 5")
        assertThat(result).isEqualTo(-3)
    }
}
