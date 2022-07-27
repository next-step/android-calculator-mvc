package edu.nextstep.camp.caculator

import com.google.common.truth.Truth.*
import edu.nextstep.camp.caculator.domain.Calculator
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun plus() {
        // When
        val actual = calculator.plus(3, 4)

        // Then
        assertThat(actual).isEqualTo(7)
    }

    @Test
    fun minus() {
        // When
        val actual = calculator.minus(3, 4)

        // Then
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun divide() {
        // When
        val actual = calculator.divide(6, 3)

        // Then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun multiply() {
        // When
        val actual = calculator.multiply(6, 3)

        // Then
        assertThat(actual).isEqualTo(18)
    }

    @Test
    fun calculate() {
        // When
        val actual = calculator.calculate("2 + 2 - 2 * 2 / 2")

        // Then
        assertThat(actual).isEqualTo(2)
    }

    @Test(expected = IllegalArgumentException::class)
    fun validateExpression1() {
        // When
        calculator.calculate("     ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun validateExpression2() {
        // When
        calculator.calculate("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun validateExpression3() {
        // When
        calculator.calculate("test")
    }
}