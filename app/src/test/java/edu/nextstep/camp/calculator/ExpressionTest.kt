package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.Number
import edu.nextstep.camp.calculator.domain.Operator
import org.junit.Test

class ExpressionTest {

    @Test
    fun `연산자 뒤에는 다른 연산자가 들어올 수 없다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("4"))
            writeOperator(Operator.Plus)
        }

        //when
        expression.writeOperator(Operator.Multiply)
        expression.writeOperator(Operator.Plus)
        expression.writeOperator(Operator.Plus)

        //then
        assertThat(expression.getValue().length).isEqualTo(2)
    }

    @Test
    fun `계산식의 끝이 연산자일 때 연속으로 연산자가 붙는 경우, 연산자는 새로운 연산로 치환된다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("4"))
            writeOperator(Operator.Plus)
        }

        //when
        expression.writeOperator(Operator.Minus)

        //then
        val lastOperator = expression.getValue().last()
        assertThat(lastOperator.toString()).isEqualTo("-")
    }

    @Test
    fun `빈 계산식에는 어떠한 수식도 들어갈 수 없다`() {
        //given
        val expression = Expression()

        //when
        expression.writeOperator(Operator.Plus)
        expression.writeOperator(Operator.Minus)
        expression.writeOperator(Operator.Multiply)
        expression.writeOperator(Operator.Divide)

        //then
        assertThat(expression.getValue()).isEmpty()
    }

    @Test
    fun `수식이 주어지면 해당 수식을 순서대로 계산한다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
            writeOperator(Operator.Plus)
            writeNumber(Number("5"))
            writeOperator(Operator.Multiply)
            writeNumber(Number("4"))
        }

        //when
        val result = expression.calculate()

        //then
        assertThat(result).isEqualTo("44")
    }

    @Test
    fun `수식의 마지막이 연산자일때 계산을 하게되면 마지막 연산자는 생략한다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
            writeOperator(Operator.Plus)
            writeNumber(Number("5"))
            writeOperator(Operator.Plus)
        }

        //when
        val result = expression.calculate()

        //then
        assertThat(result).isEqualTo("11")
    }

    @Test
    fun `계산을 하고나면 계산 결과만 스택에 존재한다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
            writeOperator(Operator.Plus)
            writeNumber(Number("5"))
        }

        //when
        val result = expression.calculate()

        //then
        assertThat(expression.getValue()).isEqualTo("11")
    }

    @Test
    fun `모든 계산식을 지운다`() {
        //given
        val expression = Expression().apply {
            writeNumber(Number("6"))
            writeOperator(Operator.Plus)
            writeNumber(Number("5"))
        }

        //when
        val result = expression.deleteExpression()

        //then
        assertThat(expression.getValue()).isEqualTo("")
    }
}
