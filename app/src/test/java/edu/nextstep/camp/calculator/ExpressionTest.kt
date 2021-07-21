package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.Operator.Companion.DIVIDE
import edu.nextstep.camp.calculator.Operator.Companion.MINUS
import edu.nextstep.camp.calculator.Operator.Companion.MULTIPLY
import edu.nextstep.camp.calculator.Operator.Companion.PLUS
import org.junit.Test
import java.util.*

class ExpressionTest {

    @Test(expected = IllegalArgumentException::class)
    fun `수식이 공백일 경우 Exception이 발생한다`() {
        val blankExpression = ""
        Expression.create(blankExpression)
    }

    @Test
    fun `수식에 공백이 존재한다면 모두 제거해준다`() {
        //given
        val string = "1 + 3 + 4 "

        //when
        val expression = Expression.create(string)

        //then
        assertThat(expression.value).isEqualTo("1+3+4")
    }


    @Test
    fun `수식이 주어지면 해당 수식을 순서대로 계산한다`() {
        //given
        val expression = Expression.create("1 + 4 × 6")
        val expression2 = Expression.create("3 ÷ 3")
        val expression3 = Expression.create("3")

        //when
        val result = expression.calculate()
        val result2 = expression2.calculate()
        val result3 = expression3.calculate()

        //then
        assertThat(result).isEqualTo(Number(30))
        assertThat(result2).isEqualTo(Number(1))
        assertThat(result3).isEqualTo(Number(3))
    }
}
