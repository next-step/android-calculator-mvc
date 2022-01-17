package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Calculator
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Before
    fun setUp() {
        calculator.initCalculator()
    }

    @Test
    fun test_calculate_plus() {
        calculator.setCalculatorContents("1 + 2 + 3")
        val result = calculator.calculateContents()
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun test_calculate_minus() {
        calculator.setCalculatorContents("4 - 5 - 6")
        val result = calculator.calculateContents()
        assertThat(result).isEqualTo(-7)
    }

    @Test
    fun test_calculate_multiplication() {
        calculator.setCalculatorContents("7 * 8 * 9")
        val result = calculator.calculateContents()
        assertThat(result).isEqualTo(504)
    }

    @Test
    fun test_calculate_division() {
        calculator.setCalculatorContents("10 / 8 / 5")
        val result = calculator.calculateContents()
        assertThat(result).isEqualTo(0.25)
    }

    @Test
    fun test_calculate_null() {
        calculator.setCalculatorContents("")
        try {
            calculator.calculateContents()
        } catch (e: Exception) {
            assertThat(e).isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test
    fun test_calculate_not_proper_operation() {
        calculator.setCalculatorContents("1 # 4 @ 7")
        try {
            calculator.calculateContents()
        } catch (e: Exception) {
            assertThat(e).isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test
    fun test_calculate_all_the_operation() {
        calculator.setCalculatorContents("1 + 2 * 4 / 6 - 5")
        val result = calculator.calculateContents()
        assertThat(result).isEqualTo(-3)
    }
}
