package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
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

    @RunWith(Parameterized::class)
    class CalculatorOperatorTest(val inputFunction: String, private val expectResult: Double) {
        private val calculator = Calculator()

        @Test
        fun 연산자가_하나인_경우의_계산() {
            assertThat(calculator.calculate(inputFunction)).isEqualTo(expectResult)
        }

        companion object {
            @JvmStatic
            @Parameterized.Parameters(name = "{index} - {0}의 계산 결과는 {1}이 되어야 한다.")
            fun testData(): Collection<Array<Any>> {
                return listOf(
                    arrayOf("1 + 1", 2.0),
                    arrayOf("2 - 1", 1.0),
                    arrayOf("2 / 1", 2.0),
                    arrayOf("3 / 2", 1.5),
                    arrayOf("4 * 2", 8.0),
                    arrayOf("1 * 1", 1.0),
                )
            }
        }
    }

    @RunWith(Parameterized::class)
    class CalculatorMoreThenTwoOperatorTest(
        val inputFunction: String,
        private val expectResult: Double
    ) {
        private val calculator = Calculator()

        @Test
        fun 연산자가_두개_이상인_경우의_계산() {
            assertThat(calculator.calculate(inputFunction)).isEqualTo(expectResult)
        }

        companion object {
            @JvmStatic
            @Parameterized.Parameters(name = "{index} - {0}의 계산 결과는 {1}이 되어야 한다.")
            fun testData(): Collection<Array<Any>> {
                return listOf(
                    arrayOf("1 + 1 + 1", 3.0),
                    arrayOf("2 - 1 - 1", 0.0),
                    arrayOf("2 / 1 - 1", 1.0),
                    arrayOf("3 / 2 + 0.5", 2.0),
                    arrayOf("4 * 2 + 2", 10.0),
                    arrayOf("1 * 2 * 3 / 6", 1.0),
                    arrayOf("1 * 1 - 2 / 0.25 + 4", 0.0)
                )
            }
        }
    }
}