package camp.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorTest {

    @Test
    fun `덧셈 테스트`() {
        //given
        val expression = "2 + 3"
        val delimiter = " "
        val expected = 5

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `뺄셈 테스트`() {
        //given
        val expression = "2 - 3"
        val delimiter = " "
        val expected = -1

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `곱셈 테스트`() {
        //given
        val expression = "2 * 3"
        val delimiter = " "
        val expected = 6

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `나눗셈 테스트`() {
        //given
        val expression = "3 / 3"
        val delimiter = " "
        val expected = 1

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException throw 테스트`() {
        //given
        val expression = null

        //when
        val result = Calculator.requiredInput(expression)

        //then
        assertThrows(IllegalArgumentException::class.java){result}
    }

    @Test
    fun `입력값이 공백 문자일 경우 IllegalArgumentException throw 테스트`() {
        //given
        val expression = " "

        //when
        val result = Calculator.requiredInput(expression)

        //then
        assertThrows(IllegalArgumentException::class.java){result}
    }

    @Test
    fun `사칙연산 기호가 아닌 문자인 경우 IllegalArgumentException throw 테스트`() {
        //given
        val expression = "2 $ 3"
        val delimiter = " "

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThrows(IllegalArgumentException::class.java) { result }
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현 테스트1`() {
        //given
        val input = "1 + 2 + 3"
        val delimiter = " "

        //when
        val actual: Int = Calculator.evaluate(input, delimiter)

        //then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현 테스트2`() {
        //given
        val input = "2 + 3 * 4 / 2"
        val delimiter = " "

        //when
        val actual: Int = Calculator.evaluate(input, delimiter)

        //then
        assertThat(actual).isEqualTo(10)
    }
}
