package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class OperatorTest {

    private val firstOperand = 20.0
    private val secondOperand = 10.0

    @Test
    fun `두 개의 피연산자를 더합니다`() {
        assertThat(Operator.PLUS.formula(firstOperand, secondOperand)).isEqualTo(30.0)
    }

    @Test
    fun `두 개의 피연산자를 뺍니다`() {
        assertThat(Operator.MINUS.formula(firstOperand, secondOperand)).isEqualTo(10.0)
    }

    @Test
    fun `두 개의 피연산자를 곱합니다`() {
        assertThat(Operator.MULTIPLE.formula(firstOperand, secondOperand)).isEqualTo(200.0)
    }

    @Test
    fun `두 개의 피연산자를 나눕니다`() {
        assertThat(Operator.DIVIDE.formula(firstOperand, secondOperand)).isEqualTo(2.0)
    }

    @Test
    fun `피연산자를 0으로 나누면 에러가 발생합니다`(){
        assertThatExceptionOfType(ArithmeticException::class.java).isThrownBy {
            Operator.DIVIDE.formula(firstOperand, 0.0)
        }
    }

    @ParameterizedTest
    @ValueSource(chars = ['+', '-', '*', '/'])
    fun `연산자가 유효한지 체크합니다`(symbol: Char) {
        assertThat(Operator.findBySymbol(symbol))
    }

    @ParameterizedTest
    @ValueSource(chars = ['!', '@', '#', '$', '%', '^', '&', '_', '='])
    fun `연산자가 유효하지 않으면 NONE을 반환합니다`(symbol: Char) {
        assertThat(Operator.findBySymbol(symbol)).isEqualTo(Operator.NONE)
    }
}
