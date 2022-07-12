package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calcluator.domain.Calculator
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `연산자가 연속으로 들어오는 경우에는 마지막 연산자를 사용한다`() {
        //given
        val input = "1 * + * 2 *  /      - 3"
        val excepted = -1

        //when
        val actual = calculator.evalute(input)

        //then
        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun `연산자가 없는 경우에는 숫자만 반환한다`() {
        //given
        val input = "1 2 3"
        val excepted = 123

        //when
        val actual = calculator.evalute(input)

        //then
        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun 덧셈() {
        //given
        val input = "11 +    222"
        val excepted = 233

        //when
        val actual = calculator.evalute(input)

        //then
        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun 뺄셈() {
        //given
        val input = "11 -    222"
        val excepted = -211

        //when
        val actual = calculator.evalute(input)

        //then
        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun 나눗셈() {
        //given
        val input = "222 /    2 / 111"
        val excepted = 1

        //when
        val actual = calculator.evalute(input)

        //then
        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw`() {
        //given
        val input = null
        val exceptedInstanceOf = IllegalArgumentException::class.java

        //when
        val actual = runCatching {
            calculator.evalute(input)
        }.exceptionOrNull()

        //then
        assertThat(actual).isInstanceOf(exceptedInstanceOf)

    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        //given
        val input = "121 + % 222"
        val exceptedInstanceOf = IllegalArgumentException::class.java

        //when
        val actual = runCatching {
            calculator.evalute(input)
        }.exceptionOrNull()

        //then
        assertThat(actual).isInstanceOf(exceptedInstanceOf)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현`() {
        //given
        val input = "2 + 3 * 4 / 2"
        val excepted = 10

        //when
        val actual = calculator.evalute(input)

        //then
        assertThat(actual).isEqualTo(excepted)
    }
}