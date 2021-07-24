package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.Number
import edu.nextstep.camp.calculator.domain.Operator
import edu.nextstep.camp.calculator.domain.Operator.Companion.DIVIDE
import edu.nextstep.camp.calculator.domain.Operator.Companion.MINUS
import edu.nextstep.camp.calculator.domain.Operator.Companion.MULTIPLY
import edu.nextstep.camp.calculator.domain.Operator.Companion.PLUS
import org.junit.Test

class ExpressionTest {

    @Test
    fun `연산자 뒤에는 다른 연산자가 들어올 수 없다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("4"))
            writeOperator(Operator(PLUS))
        }

        //when
        expression.writeOperator(Operator(MULTIPLY))
        expression.writeOperator(Operator(PLUS))
        expression.writeOperator(Operator(PLUS))

        //then
        assertThat(expression.getValue().length).isEqualTo(2)
    }

    @Test
    fun `계산식의 끝이 연산자일 때 연속으로 연산자가 붙는 경우, 연산자는 새로운 연산로 치환된다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("4"))
            writeOperator(Operator(PLUS))
        }

        //when
        expression.writeOperator(Operator(MINUS))

        //then
        val lastOperator = expression.getValue().last()
        assertThat(lastOperator.toString()).isEqualTo(MINUS)
    }

    @Test
    fun `빈 계산식에는 어떠한 수식도 들어갈 수 없다`() {
        //given
        val expression = Expression()

        //when
        expression.writeOperator(Operator(PLUS))
        expression.writeOperator(Operator(MINUS))
        expression.writeOperator(Operator(MULTIPLY))
        expression.writeOperator(Operator(DIVIDE))

        //then
        assertThat(expression.getValue()).isEmpty()
    }

    @Test
    fun `수식이 주어지면 해당 수식을 순서대로 계산한다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
            writeOperator(Operator(PLUS))
            writeNumber(Number("5"))
            writeOperator(Operator(MULTIPLY))
            writeNumber(Number("4"))
        }

        //when
        val result = expression.calculate()


        //then
        assertThat(result).isEqualTo(Number(44))
    }

    @Test
    fun `수식의 마지막이 연산자일때 계산을 하게되면 마지막 연산자는 생략한다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
            writeOperator(Operator(PLUS))
            writeNumber(Number("5"))
            writeOperator(Operator(MULTIPLY))
        }

        //when
        val result = expression.calculate()

        //then
        assertThat(result).isEqualTo(Number(11))
    }

    @Test
    fun `수식에 한개의 숫자만 존재할때 계산을 하면 해당 숫자만 출력된다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
        }

        //when
        val result = expression.calculate()

        //then
        assertThat(result).isEqualTo(Number(6))
    }
}
