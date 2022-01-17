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
        assertEquals(6.0, actual, 0.00001)
    }

    @Test
    fun test_minus_calculation() {
        // when : 사용자가 뺄셈 식을 입력하면
        val actual: Double = calculator.evaluate("10-2-3")

        // then : 올바른 뺄셈 결과를 계산한다
        assertEquals(5.0, actual, 0.00001)
    }

    @Test
    fun test_multiple_calculation() {
        // when : 사용자가 곱셈 식을 입력하면
        val actual: Double = calculator.evaluate("10*-5*9")

        // then : 올바른 곱셈 결과를 계산한다
        assertEquals(-450.0, actual, 0.00001)
    }

    @Test
    fun test_divide_calculation() {
        // when : 사용자가 나눗셈 식을 입력하면
        var actual: Double = calculator.evaluate("120/2/3")

        // then : 올바른 나눗셈 결과를 계산한다
        assertEquals(20.0, actual, 0.00001)

        // when : 사용자가 나눗셈 식을 입력하면
        actual = calculator.evaluate("10/3")

        // then : 올바른 나눗셈 결과를 계산한다
        assertEquals(3.3333333, actual, 0.00001)
    }

    @Test
    fun test_null_input_calculation() {
        // when : 사용자가 사칙연산 식에 null을 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("120+null/3") }

        // then : IllegalArgumentException 을 발생시킨다
        assertEquals(IllegalArgumentException::class.java, thrown.javaClass)
    }

    @Test
    fun test_blank_input_calculation() {
        // when : 사용자가 사칙연산 식에 빈 문자열을 입력하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("120/10- *3+ /1") }

        // then : IllegalArgumentException 을 발생시킨다
        assertEquals(IllegalArgumentException::class.java, thrown.javaClass)
    }

    @Test
    fun test_no_arithmetic_input_calculation() {
        // when : 사용자가 사칙연산 식에 사칙연산이 아닌 기호를 포함하면
        val thrown: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.evaluate("5$7~3x8") }

        // then : IllegalArgumentException 을 발생시킨다
        assertEquals(IllegalArgumentException::class.java, thrown.javaClass)
    }

    @Test
    fun test_all_arithmetic_input_calculation() {
        // when : 사용자가 사칙연산을 모두 포함하는 사칙연산 식을 입력하면
        var actual: Double = calculator.evaluate("2 + 3 * 4 / 2")

        // then : 올바른 계산 결과를 계산한다
        assertEquals(10.0, actual, 0.00001)

        // when : 사용자가 사칙연산을 모두 포함하는 사칙연산 식을 입력하면
        actual = calculator.evaluate("+10*+2-10/+10")

        // then : 올바른 계산 결과를 계산한다
        assertEquals(1.0, actual, 0.00001)


    }

    @Test
    fun test_exception_input() {
        // when : 사용자가 예외가 발생하는  사칙연산 식을 입력하면
        // then : IllegalArgumentException 을 발생시킨다
        val exceptionStringList: Array<String> = arrayOf("10+ 2 /- 3 * - + 2", "1/0", "2+3*(5-3)", "10+2---2", "10+010")

        for (exceptionString in exceptionStringList) {
            println(exceptionStringList.indexOf(exceptionString).toString() + "번 째 " + exceptionString + " test start")
            val thrown: IllegalArgumentException = assertThrows(
                IllegalArgumentException::class.java
            ) { calculator.evaluate(exceptionString) }

            assertEquals(IllegalArgumentException::class.java, thrown.javaClass)
        }
    }
}