package camp.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    @Test
    fun `2 + 3의 연산식을 계산하면, 결과가 5가 나와야한다`() {
        //given
        val expression = "2 + 3"
        val expected = 5

        //when
        val result = Calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `2 - 3의 연산식을 계산하면, 결과가 -1이 나와야한다`() {
        //given
        val expression = "2 - 3"
        val expected = -1

        //when
        val result = Calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `2 * 3의 연산식을 계산하면, 결과가 6이 나와야한다`() {
        //given
        val expression = "2 * 3"
        val expected = 6

        //when
        val result = Calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `3 나누기 3의 연산식을 계산하면, 결과가 1이 나와야한다`() {
        //given
        val expression = "3 / 3"
        val expected = 1

        //when
        val result = Calculator.evaluate(expression)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `사칙연산 기호가 아닌 문자인 경우 IllegalArgumentException throw 테스트`() {
        //given
        val expression = "2 $ 3"

        //then
        assertThrows(IllegalArgumentException::class.java) {
            Calculator.evaluate(expression)
        }
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현 테스트1`() {
        //given
        val expression = "1 + 2 + 3"

        //when
        val actual: Int = Calculator.evaluate(expression)

        //then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현 테스트 2`() {
        //given
        val expression = "2 + 3 * 4 / 2"

        //when
        val actual: Int = Calculator.evaluate(expression)

        //then
        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun `"1+1" 표현식이 경우, 에러가 발생해야한다`() {
        //given
        val expression = "1+1"

        //when
        fun actual() = Calculator.evaluate(expression)

        //then
        assertThrows(IllegalArgumentException::class.java) { actual() }
    }

    @Test
    fun `"a + 123" 표현식이 경우, 에러가 발생해야한다`() {
        //given
        val expression = "a + 123"

        //when
        fun actual() = Calculator.evaluate(expression)

        //then
        assertThrows(IllegalArgumentException::class.java) { actual() }
    }

    @Test
    fun `"1 + + 1" 표현식이 경우, 에러가 발생해야한다`() {
        //given
        val expression = "1 + + 1"

        //when
        fun actual() = Calculator.evaluate(expression)

        //then
        assertThrows(IllegalArgumentException::class.java) { actual() }
    }

}
