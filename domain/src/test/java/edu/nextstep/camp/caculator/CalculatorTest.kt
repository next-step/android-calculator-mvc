package edu.nextstep.camp.caculator

import com.google.common.truth.Truth.*
import edu.nextstep.camp.caculator.domain.Calculator
import edu.nextstep.camp.caculator.domain.Expression
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun calculate_operators_test() {
        // When
        val actual = calculator.calculate(Expression("2 + 2 - 2 * 2 / 2"))

        // Then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun calculate_minus_result_test() {
        // When
        val actual = calculator.calculate(Expression("2 - 9"))

        // Then
        assertThat(actual).isEqualTo(-7)
    }
}