package edu.nextstep.camp.calculator.domain

import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun 계산이_정상_작동_하는지_확인한다() {
        val actual = calculator.evaluate("2 + 3 * 4 / 2")
        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun 사칙연산_기호_외에_다른_문자가_들어오면_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("2 * 3 ) 2")
        }
    }

    @Test
    fun 첫번째_항목에_연산자가_들어오면_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("+ 2 / 3")
        }
    }

    @Test
    fun 마지막_항목에_연산자가_들어오면_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("3 + 2 /")
        }
    }

    @Test
    fun 공백으로_나누어지지_않은_문자가_들어오면_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("3+ 2 / 3")
        }
    }

    @Test
    fun 입력값으로_null이_들어오면_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate(null)
        }
    }

    @Test
    fun 입력값으로_공백문자가_들어오면_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate(" ")
        }
    }
}