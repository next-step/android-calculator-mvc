package camp.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var rawExpressionCheck: RawExpressionCheck

    @Before
    fun settings() {
        rawExpressionCheck = RawExpressionCheck()
    }

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

        //then
        assertThrows(IllegalArgumentException::class.java) {
            rawExpressionCheck.isNullOrBlankCheck(
                expression
            )
        }
    }

    @Test
    fun `입력값이 공백 문자일 경우 IllegalArgumentException throw 테스트`() {
        //given
        val expression = " "

        //then
        assertThrows(IllegalArgumentException::class.java) {
            rawExpressionCheck.isNullOrBlankCheck(expression)
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 문자인 경우 IllegalArgumentException throw 테스트`() {
        //given
        val expression = "2 $ 3"
        val delimiter = " "

        //then
        assertThrows(IllegalArgumentException::class.java) {
            Calculator.evaluate(
                expression,
                delimiter
            )
        }
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현 테스트1`() {
        //given
        val expression = "1 + 2 + 3"
        val delimiter = " "

        //when
        val actual: Int = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현 테스트 2`() {
        //given
        val expression = "2 + 3 * 4 / 2"
        val delimiter = " "

        //when
        val actual: Int = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun `파라미터로 들어오는 표현식에 대한 테스트 1`() {
        //given
        val expression = "1+1"
        val delimiter = " "

        //when
        fun actual() = Calculator.evaluate(expression, delimiter)

        //then
        assertThrows(IllegalArgumentException::class.java) { actual() }
    }

    @Test
    fun `파라미터로 들어오는 표현식에 대한 테스트 2`() {
        //given
        val expression = "a + 123"
        val delimiter = " "

        //when
        fun actual() = Calculator.evaluate(expression, delimiter)

        //then
        assertThrows(IllegalArgumentException::class.java) { actual() }
    }

    @Test
    fun `파라미터로 들어오는 표현식에 대한 테스트 3`() {
        //given
        val expression = "1 + + 1"
        val delimiter = " "

        //when
        fun actual() = Calculator.evaluate(expression, delimiter)

        //then
        assertThrows(IllegalArgumentException::class.java) { actual() }
    }

}
