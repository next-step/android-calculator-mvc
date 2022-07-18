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

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    //뺄셈
    @Test
    fun testMinus() {
        //given
        val expression = "2 - 3"
        val delimiter = " "
        val expected = -1

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    //곱셈
    @Test
    fun testMultiply() {
        //given
        val expression = "2 * 3"
        val delimiter = " "
        val expected = 6

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    //나눗셈
    @Test
    fun testDivide() {
        //given
        val expression = "3 / 3"
        val delimiter = " "
        val expected = 1

        //then
        assertThat(Calculator.evaluate(expression, delimiter)).isEqualTo(expected)
    }

    //입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    @Test
    fun testNullInput() {
        //given
        val expression = null

        //then
        assertThrows(IllegalArgumentException::class.java){Calculator.requiredInput(expression)}
    }

    @Test
    fun testBlankInput() {
        //given
        val expression = " "

        //then
        assertThrows(IllegalArgumentException::class.java){Calculator.requiredInput(expression)}
    }

    //사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    @Test
    fun testNonOperatorInput() {
        //given
        val expression = "2 $ 3"
        val delimiter = " "

        //then
        assertThrows(IllegalArgumentException::class.java) { Calculator.evaluate(expression, delimiter) }
    }

    //사칙 연산을 모두 포함하는 기능 구현
    @Test
    fun `testEvaluate1`() {
        val actual: Int = Calculator.evaluate("1 + 2 + 3", " ")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `testEvaluate2`() {
        val actual: Int = Calculator.evaluate("2 + 3 * 4 / 2", " ")
        assertThat(actual).isEqualTo(10)
    }
}