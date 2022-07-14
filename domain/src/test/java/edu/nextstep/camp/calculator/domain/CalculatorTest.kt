package edu.nextstep.camp.calculator.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Created by link.js on 2022. 07. 13..
 */

@RunWith(Parameterized::class)
class CalculatorTest(private val expression: String, private val answer: Int) {

    @Test
    fun `계산기가 정상 동작한다`() {
        assertEquals(Calculator().evaluate(expression),answer)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: ({0}) = {1}")
        fun data() = listOf(
            arrayOf("2 + 3", 5),
            arrayOf("5 * 2 - 3", 7),
            arrayOf("200 - 10 / 10", 19),
            arrayOf("10 - 2 / 4", 2),
            arrayOf("6 - 0 + 3", 9)
        )
    }
}

class CalculatorExceptionTest {
    private val calculator = Calculator()

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate(null)
        }
    }

    @Test
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("")
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("2 [ 3")
        }
    }

    @Test
    fun `숫자 위치에 숫자가 아닌 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("2 3 3")
        }
    }

    @Test
    fun `0으로 나눌 경우 IllegalArgumentException throw`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("2 / 0")
        }
    }
}