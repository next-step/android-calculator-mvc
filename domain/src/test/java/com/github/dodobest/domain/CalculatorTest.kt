package com.github.dodobest.domain

import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class CalculatorTest(val inputString: String, val expectedResult: Any) {
    private val calculator = Calculator()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf("10+ 2 /- 3 * - + 2", IllegalArgumentException::class.java), // 사용자가 사칙연산 기호를 연속으로 입력하면
                arrayOf("10+2---2", IllegalArgumentException::class.java), // when : 사용자가 사칙연산 기호를 연속으로 입력하면
                arrayOf("1/0", IllegalArgumentException::class.java), // when : 사용자가 0으로 나누는 사칙연산 식을 입력하면
                arrayOf("2+3*(5-3)", IllegalArgumentException::class.java), // when : 사용자가 사칙연산 식에 괄호를 포함하면
                arrayOf("10+010", IllegalArgumentException::class.java), // when : 사용자가 0으로 시작하는 숫자를 입력하면
                arrayOf("5\$7~3x8", IllegalArgumentException::class.java), // when : 사용자가 사칙연산 식에 사칙연산이 아닌 기호를 포함하면
                arrayOf("120/10- *3+ /1", IllegalArgumentException::class.java), // when : 사용자가 사칙연산 식에 빈 문자열을 입력하면
                arrayOf("120+null/3", IllegalArgumentException::class.java), // when : 사용자가 사칙연산 식에 null을 입력하면

                arrayOf("1+2+3", 6), // when : 사용자가 덧셈 식을 입력하면
                arrayOf("10-2-3", 5), // when : 사용자가 뺄셈 식을 입력하면
                arrayOf("10*-5*9", -450), // when : 사용자가 곱셈 식을 입력하면
                arrayOf("120/2/3", 20), // when : 사용자가 나누어 떨어지는 나눗셈 식을 입력하면
                arrayOf("10/3", 3.3333333), // when : 사용자가 나누어 떨어지지 않는 나눗셈 식을 입력하면
                arrayOf("2 + 3 * 4 / 2", 10), // when : 사용자가 사칙연산을 모두 포함하는 사칙연산 식을 입력하면

            )
        }
    }

    @Test
    fun testCalculatorIsWorkingExpectedWithArithmeticOperation() {
        if (expectedResult is Int) {
            val actual = calculator.evaluate(inputString)

            assertThat(actual).isEqualTo(expectedResult)
        } else if (expectedResult is Double) {
            val actual = calculator.evaluate(inputString)

            assertThat(actual).isWithin(1.0e-5).of(expectedResult)
        } else if (expectedResult is IllegalArgumentException) {
            val thrown: IllegalArgumentException = assertThrows(
                IllegalArgumentException::class.java
            ) { calculator.evaluate(inputString) }
            assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
        }
    }

}