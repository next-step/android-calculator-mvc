package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.Number
import edu.nextstep.camp.calculator.domain.Operator
import org.junit.Test

class CalculatorTest {

    @Test
    fun `일반적인 계산식이 주어졌을 경우`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
            writeOperator(Operator.of("+"))
            writeNumber(Number("5"))
            writeOperator(Operator.of("×"))
            writeNumber(Number("5"))
        }

        //when
        val result = expression.calculate()

        //then
        assertThat(result).isEqualTo("55")
    }

    @Test
    fun `계산식에 숫자가 하나만 존재할때 계산하기를 누르면 하나의 값이 출력된다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
        }

        //when
        val result = expression.calculate()

        //then
        assertThat(result).isEqualTo("6")
    }

    @Test
    fun `빈 계산식에 계산하기를 누르면 아무 일도 일어나지 않는다`() {
        //given
        val expression = Expression()

        //when
        val result = expression.calculate()

        //then
        assertThat(result).isEqualTo("")
    }
}