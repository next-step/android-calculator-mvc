package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.operand.NumberOperand
import edu.nextstep.camp.calculator.domain.operand.Operator
import org.junit.Test

class ExpressionHolderTest {
    @Test
    fun `최근값이 피연산자일때, 피연산자를 더하면, 기존 피연산자가 변경된다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
        }
        // when
        expression.addOperand(NumberOperand(5.0))
        // then
        assertThat(expression.getCurrentExpression()).isEqualTo("35")
    }

    @Test
    fun `최근값이 피연산자일때, 연산자를 더하면, 피연산자가 추가된다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
        }
        // when
        expression.addOperand(Operator.MULTIPLY)
        // then
        assertThat(expression.getCurrentExpression()).isEqualTo("3×")
    }

    @Test
    fun `최근값이 연산자일때, 연산자를 더하면, 기존 연산자가 변경된다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
            addOperand(Operator.PLUS)
        }
        // when
        expression.addOperand(Operator.MULTIPLY)
        // then
        assertThat(expression.getCurrentExpression()).isEqualTo("3×")
    }

    @Test
    fun `최근값이 연산자일때, 피연산자를 더하면, 피연산자가 추가된다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
            addOperand(Operator.PLUS)
        }
        // when
        expression.addOperand(NumberOperand(5.0))
        // then
        assertThat(expression.getCurrentExpression()).isEqualTo("3+5")
    }

    //Delete
    @Test
    fun `최근값이 두자리 이상의 피연산자일때, 마지막 값을 지우면, 피연산자의 마지막 숫자가 지워진다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
            addOperand(Operator.PLUS)
            addOperand(NumberOperand(55.0))
        }
        // when
        expression.deleteLast()
        // then
        assertThat(expression.getCurrentExpression()).isEqualTo("3+5")
    }

    @Test
    fun `최근값이 한자리의 피연산자일때, 마지막 값을 지우면, 피연산자가 지워진다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
            addOperand(Operator.PLUS)
            addOperand(NumberOperand(5.0))
        }
        // when
        expression.deleteLast()
        // then
        assertThat(expression.getCurrentExpression()).isEqualTo("3+")
    }

    @Test
    fun `최근값이 연산자일때, 마지막 값을 지우면, 연산자가 지워진다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
            addOperand(Operator.PLUS)
        }
        // when
        expression.deleteLast()
        // then
        assertThat(expression.getCurrentExpression()).isEqualTo("3")
    }

    @Test
    fun `최근값이 없을때, 마지막 값을 지우면, 표현식이 비어있다`() {
        // given
        val expression = ExpressionHolder()
        // when
        expression.deleteLast()
        // then
        assertThat(expression.getCurrentExpression()).isEqualTo("")
    }

    @Test
    fun `정상적인 표현식 입력후, 결과값을 받아오면 계산된 값이 나와야한다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
            addOperand(Operator.PLUS)
            addOperand(NumberOperand(55.0))
        }
        // when
        val result = expression.getResult()
        // then
        assertThat(result).isEqualTo((3 + 55))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `비 정상적인 표현식 입력후, 결과값을 받아오면 에러가 발생한다`() {
        // given
        val expression = ExpressionHolder().apply {
            addOperand(NumberOperand(3.0))
            addOperand(Operator.PLUS)
            addOperand(NumberOperand(55.0))
            addOperand(Operator.MULTIPLY)
        }
        // when
        val result = expression.getResult()
    }
}
