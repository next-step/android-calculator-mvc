package com.github.dodobest.domain

import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun test_plus_calculation() {
        // when : 사용자가 덧셈 식을 입력하면
        val actual: Double = calculator.evaluate("1+2+3")

        // then : 올바른 덧셈 결과를 계산한다
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun test_minus_calculation() {
        // when : 사용자가 뺄셈 식을 입력하면
        val actual: Double = calculator.evaluate("10-2-3")

        // then : 올바른 뺄셈 결과를 계산한다
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun test_multiple_calculation() {
        // when : 사용자가 곱셈 식을 입력하면
        val actual: Double = calculator.evaluate("10*-5*9")

        // then : 올바른 곱셈 결과를 계산한다
        assertThat(actual).isEqualTo(-450)
    }

    @Test
    fun test_divide_calculation() {
        // when : 사용자가 나누어 떨어지는 나눗셈 식을 입력하면
        val actual: Double = calculator.evaluate("120/2/3")

        // then : 올바른 나눗셈 결과를 계산한다
        assertThat(actual).isEqualTo(20)
    }

    @Test
    fun test_not_divided_calculation() {
        // when : 사용자가 나누어 떨어지지 않는 나눗셈 식을 입력하면
        val actual = calculator.evaluate("10/3")

        // then : 올바른 나눗셈 결과를 계산한다
        assertThat(actual).isWithin(1.0e-5).of(3.3333333)
    }

    @Test
    fun test_all_arithmetic_input_calculation() {
        // when : 사용자가 사칙연산을 모두 포함하는 사칙연산 식을 입력하면
        val actual: Double = calculator.evaluate("2 + 3 * 4 / 2")

        // then : 올바른 계산 결과를 계산한다
        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun test_positive_num_sign_calculation() {
        // when : +가 붙은 양수를 입력하면
        val actual: Double = calculator.evaluate("+10+10/+20")

        // then : 올바른 계산 결과를 계산한다
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun test_null_input_calculation() {
        // when : 사용자가 사칙연산 식에 null을 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("120+null/3") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun test_blank_input_calculation() {
        // when : 사용자가 사칙연산 식에 빈 문자열을 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("120/10- *3+ /1") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun test_no_arithmetic_input_calculation() {
        // when : 사용자가 사칙연산 식에 사칙연산이 아닌 기호를 포함하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("5$7~3x8") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun test_arithmetic_input_consecutive_calculation() {
        // 사용자가 사칙연산 기호를 연속으로 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("10+ 2 /- 3 * - + 2") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun test_arithmetic_minus_consecutive_calculation() {
        // when : 사용자가 사칙연산 기호 -를 연속으로 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("10+2---+---2") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun test_arithmetic_plus_consecutive_calculation() {
        // when : 사용자가 사칙연산 기호 -를 연속으로 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("10+2+++-+++2") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun test_divide_with_zero_calculation() {
        // when : 사용자가 0으로 나누는 사칙연산 식을 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("1/0") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun test_bracket_included_calculation() {
        // when : 사용자가 사칙연산 식에 괄호를 포함하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("2+3*(5-3)") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun test_zero_start_num_calculation() {
        // when : 사용자가 0으로 시작하는 숫자를 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("10+010") }

        // then : IllegalArgumentException 을 발생시킨다
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }
}