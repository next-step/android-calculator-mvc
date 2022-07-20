package camp.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorTest {

    //덧셈
    @Test
    fun testPlus() {
        //given
        val expression = "2 + 3"
        val delimiter = " "
        val expected = 5

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(result).isEqualTo(expected)
    }

    //뺄셈
    @Test
    fun testMinus() {
        //given
        val expression = "2 - 3"
        val delimiter = " "
        val expected = -1

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(result).isEqualTo(expected)
    }

    //곱셈
    @Test
    fun testMultiply() {
        //given
        val expression = "2 * 3"
        val delimiter = " "
        val expected = 6

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(result).isEqualTo(expected)
    }

    //나눗셈
    @Test
    fun testDivide() {
        //given
        val expression = "3 / 3"
        val delimiter = " "
        val expected = 1

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThat(result).isEqualTo(expected)
    }

    //입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    @Test
    fun testNullInput() {
        //given
        val expression = null

        //when
        val result = Calculator.requiredInput(expression)

        //then
        assertThrows(IllegalArgumentException::class.java){result}
    }

    @Test
    fun testBlankInput() {
        //given
        val expression = " "

        //when
        val result = Calculator.requiredInput(expression)

        //then
        assertThrows(IllegalArgumentException::class.java){result}
    }

    //사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    @Test
    fun testNonOperatorInput() {
        //given
        val expression = "2 $ 3"
        val delimiter = " "

        //when
        val result = Calculator.evaluate(expression, delimiter)

        //then
        assertThrows(IllegalArgumentException::class.java) { result }
    }

    //사칙 연산을 모두 포함하는 기능 구현
    @Test
    fun `testEvaluate1`() {
        //given
        val input = "1 + 2 + 3"
        val delimiter = " "

        //when
        val actual: Int = Calculator.evaluate(input, delimiter)

        //then
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `testEvaluate2`() {
        //given
        val input = "2 + 3 * 4 / 2"
        val delimiter = " "

        //when
        val actual: Int = Calculator.evaluate(input, delimiter)

        //then
        assertThat(actual).isEqualTo(10)
    }
}