package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Number
import edu.nextstep.camp.calculator.domain.Operator
import edu.nextstep.camp.calculator.domain.Separator
import org.junit.Test

class SeparatorTest {

    private val separator = Separator()

    @Test
    fun `계산식에서 연산자들만 분리한다`() {
        //given
        val expression = "5+3-2"

        //when
        val operators = separator.getOperators(expression)

        //then
        assertThat(operators).isEqualTo(listOf(Operator.of("+"), Operator.of("-")))
    }

    @Test
    fun `계산식에서 숫자들만 분리한다`() {
        //given
        val expression = "5+3-2"

        //when
        val operators = separator.getNumbers(expression)

        //then
        assertThat(operators).isEqualTo(listOf(Number(5), Number(3), Number(2)))
    }
}