package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test


class CalculatorTest() {

    @Test
    fun `5와 2를 더하면 7이 된다`() {
        // when
        val result = Operator.PLUS.calculate(5f, 2f)

        // then
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `5와 2를 빼면 3이 된다`() {
        // when
        val result = Operator.MINUS.calculate(5f, 2f)

        // then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `5와 2를 곱하면 10이 된다`() {
        // when
        val result = Operator.MULTIPLY.calculate(5f, 2f)

        // then
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `5와 2를 나누면 2점5가 된다`() {
        // when
        val result = Operator.DIVIDE.calculate(5f, 2f)

        // then
        assertThat(result).isEqualTo(2.5f)
    }

    @Test
    fun `8 더하기 2 곱하기 5 나누기 4 는 사칙연산 우선순위가 아닌 순서대로 연산하여 12점5가 된다`() {
        // when
        val result = Calculator.evaluate("8+2×5÷4")

        // then
        assertThat(result).isEqualTo(12.5f)
    }

    @Test
    fun `입력된 값이 공백이면 IllegalArgumentException 오류가 발생한다`() {
        // when
        assertThrows(IllegalArgumentException::class.java) {
            Calculator.evaluate("")
        }
    }

    @Test
    fun `숫자가 아닌 기호 중에 사칙연산이 아닌 경우 IllegalArgumentException 오류가 발생한다`() {
        // when
        assertThrows(IllegalArgumentException::class.java) {
            Calculator.evaluate("2^3")
        }
    }
}