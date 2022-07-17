package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.lang.IllegalArgumentException

class CalculatorDomainTest {

    @Test(expected = IllegalArgumentException::class)
    fun 입력값이_null일_경우_IlligalArgumentException_발생() {
        val calculator = Calculator()
        calculator.calculate(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun 입력이_공백일_경우_IlligalArgumentException_발생() {
        val calculator = Calculator()
        calculator.calculate(" ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun 입력에_사칙연산_기호가_아닌것이_포함된다면_IlligalArgumentException_발생() {
        val calculator = Calculator()
        calculator.calculate("1 P 1")
    }

    @Test
    fun 연산자가_하나인_경우의_계산() {
        val calculator = Calculator()
        assertThat(calculator.calculate("1 + 1")).isEqualTo(2.0)
        assertThat(calculator.calculate("2 - 1")).isEqualTo(1.0)
        assertThat(calculator.calculate("2 / 1")).isEqualTo(2.0)
        assertThat(calculator.calculate("3 / 2")).isEqualTo(1.5)
        assertThat(calculator.calculate("4 * 2")).isEqualTo(8.0)
        assertThat(calculator.calculate("1 * 1")).isEqualTo(1.0)
    }

    @Test
    fun 연산자가_두개_이상인_경우의_계산() {
        val calculator = Calculator()
        assertThat(calculator.calculate("1 + 1 + 1")).isEqualTo(3.0)
        assertThat(calculator.calculate("2 - 1 - 1")).isEqualTo(0.0)
        assertThat(calculator.calculate("2 / 1 - 1")).isEqualTo(1.0)
        assertThat(calculator.calculate("3 / 2 + 0.5")).isEqualTo(2.0)
        assertThat(calculator.calculate("4 * 2 + 2")).isEqualTo(10.0)
        assertThat(calculator.calculate("1 * 1 * 1")).isEqualTo(1.0)
    }
}