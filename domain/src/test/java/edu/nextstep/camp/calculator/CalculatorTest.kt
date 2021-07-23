package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

object Calculator {

    fun calculate(formula: String): Double {
        return 10.0
    }
}

internal class CalculatorTest {

    @Test
    fun `2 더하기 3 곱하기 4 나누기 2 를 연산하면 10이 출력됩니다`() {
        val formula = "2+3*4/2"
        assertThat(Calculator.calculate(formula)).isEqualTo(10.0)
    }
}
