package edu.nextstep.camp.calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class BinaryCalculatorTest {

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생하는지 확인한다.")
    @Test
    fun notArithmeticOperatorThrow() {
        // given
        val chunks = listOf("%", "2")

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { BinaryCalculator.of(chunks) }
    }
}