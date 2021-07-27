package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Number
import edu.nextstep.camp.calculator.domain.Operator
import org.junit.Test

class OperatorTest {

    @Test(expected = IllegalArgumentException::class)
    fun `사칙연산 기호외 다른 문자가 파라미터로 넘겨진 경우 Exception 발생`() {
        //when
        val notOperatorString = "="

        //then
        Operator.of(notOperatorString)
    }

    @Test
    fun `4과 5를 더하면 9가 나온다`() {
        //given
        val number1 = Number(4)
        val number2 = Number(5)
        val plus = Operator.of("+")

        //when
        val result = plus.calculate(number1, number2)

        //then
        assertThat(result).isEqualTo(Number(9))
    }

    @Test
    fun `4와 5를 빼면 -1이 나온다`() {
        //given
        val number1 = Number(4)
        val number2 = Number(5)
        val minus = Operator.of("-")

        //when
        val result = minus.calculate(number1, number2)

        //then
        assertThat(result).isEqualTo(Number(-1))
    }

    @Test
    fun `4와 5를 곱하면 20이 나온다`() {
        //given
        val number1 = Number(4)
        val number2 = Number(5)
        val minus = Operator.of("×")

        //when
        val result = minus.calculate(number1, number2)

        //then
        assertThat(result).isEqualTo(Number(20))
    }

    @Test
    fun `20에서 5를 나누면 4가 나온다`() {
        //given
        val number1 = Number(20)
        val number2 = Number(5)
        val minus = Operator.of("÷")

        //when
        val result = minus.calculate(number1, number2)

        //then
        assertThat(result).isEqualTo(Number(4))
    }
}