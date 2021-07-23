package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {

    private val firstOperand = 20.0
    private val secondOperand = 10.0

    @Test
    fun `두 개의 피연산자를 더합니다`() {
        assertThat(firstOperand + secondOperand).isEqualTo(30.0)
    }

    @Test
    fun `두 개의 피연산자를 뺍니다`() {
        assertThat(firstOperand - secondOperand).isEqualTo(10.0)
    }

    @Test
    fun `두 개의 피연산자를 곱합니다`() {
        assertThat(firstOperand * secondOperand).isEqualTo(200.0)
    }
}
