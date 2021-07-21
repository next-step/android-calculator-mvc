package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.Number
import org.junit.Test

class ExpressionTest {


    @Test
    fun `수식이 주어지면 해당 수식을 순서대로 계산한다`() {
        //given
        val expression = Expression().apply { writeNumber("1+4×6") }
        val expression2 = Expression().apply { writeNumber("3÷3") }
        val expression3 = Expression().apply { writeNumber("3") }

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
