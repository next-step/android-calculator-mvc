package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `덧셈이 되어야 한다`() {
        //given
        val requested = "11 +    222"
        val expected = 233.toDouble()

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun  `뺄셈이 되어야 한다`() {
        //given
        val requested = "11 -    222"
        val expected = (-211).toDouble()

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun `나눗셈이 되어야 한다`() {
        //given
        val requested = "222 /    2 / 111"
        val expected = 1.toDouble()

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun `곱셈이 되어야 한다`() {
        //given
        val requested = "222 *    2 * 3"
        val expected = 1332.toDouble()

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException throw`() {
        //given
        val requested = null
        val expected = IllegalArgumentException("잘못된 요청입니다.")

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun `입력값이 공백 일 경우 IllegalArgumentException throw`() {
        //given
        val requested = " "
        val expected = IllegalArgumentException("잘못된 요청입니다.")

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        //given
        val requested = "121  % 222"
        val expected = IllegalArgumentException("잘못된 연산자가 포함되었습니다.")

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 경우`() {
        //given
        val requested = "2 + 3 * 4 / 2"
        val expected = 10.toDouble()

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun `완성되지 않는 수식 요청의 경우 IllegaArgumentException throw`() {
        //given
        val requested = "3 * 4 / "
        val expected = IllegalArgumentException("완성되지 않은 수식입니다.")

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    @Test
    fun `연산자가 연속적으로 입력되었을 경우 IllegalArgumentException throw`() {
        //given
        val requested = "3 *//* 4"
        val expected = IllegalArgumentException("잘못된 연산자가 포함되었습니다.")

        //when
        val actual = evaluteOrException(calculator, requested)

        //then
        assertThat(actual, expected)
    }

    private fun evaluteOrException(calculator: Calculator, requested: String?) = try {
        calculator.evalute(requested)
    } catch (e: Exception) {
        e
    }

    private fun assertThat(actual: Any, expected: Any) {
        when {
            actual is Throwable && expected is Throwable -> {
                assertThat(actual).isInstanceOf(expected::class.java)
                assertThat(actual.message).startsWith(expected.message)
            }
            else -> assertThat(actual).isEqualTo(expected)
        }
    }
}