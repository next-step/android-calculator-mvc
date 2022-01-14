package com.github.dodobest.domain

import org.junit.Assert.*
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun test_plus_calculation() {
        // when : 사용자가 덧셈 식을 입력하면
        val actual: Double = calculator.evaluate("1+2+3")

        // then : 올바른 덧셈 결과를 계산한다
        assertEquals(6, actual)
    }

    @Test
    fun test_minus_calculation() {
        // when : 사용자가 뺄셈 식을 입력하면
        val actual: Double = calculator.evaluate("10-2-3")

        // then : 올바른 뺄셈 결과를 계산한다
        assertEquals(5, actual)
    }

    @Test
    fun test_multiple_calculation() {
        // when : 사용자가 곱셈 식을 입력하면
        val actual: Double = calculator.evaluate("10*-5*9")

        // then : 올바른 곱셈 결과를 계산한다
        assertEquals(450, actual)
    }

    @Test
    fun test_divide_calculation() {
        // when : 사용자가 나눗셈 식을 입력하면
        var actual: Double = calculator.evaluate("120/2/3")

        // then : 올바른 나눗셈 결과를 계산한다
        assertEquals(20, actual)

        // when : 사용자가 나눗셈 식을 입력하면
        actual = calculator.evaluate("121/2/3")

        // then : 올바른 나눗셈 결과를 계산한다
        assertEquals(121 / 2 / 3, actual)
    }

    @Test
    fun test_null_input_calculation() {
        // when : 사용자가 사칙연산 식에 null을 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("120+null/3") }

        // then : IllegalArgumentException 을 발생시킨다
        assertEquals("IllegalArgumentException", thrown.message)
    }

    @Test
    fun test_blank_input_calculation() {
        // when : 사용자가 사칙연산 식에 빈 문자열을 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("120/10+ *3") }

        // then : IllegalArgumentException 을 발생시킨다
        assertEquals("IllegalArgumentException", thrown.message)
    }

    @Test
    fun test_no_arithmetic_input_calculation() {
        // when : 사용자가 사칙연산 식에 사칙연산이 아닌 기호를 포함하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("5+7$6") }

        // then : IllegalArgumentException 을 발생시킨다
        assertEquals("IllegalArgumentException", thrown.message)
    }

    @Test
    fun test_all_arithmetic_input_calculation() {
        // when : 사용자가 사칙연산을 모두 포함하는 사칙연산 식을 입력하면
        val actual: Double = calculator.evaluate("2 + 3 * 4 / 2")

        // then : 올바른 계산 결과를 계산한다
        assertEquals(10, actual)
    }
}