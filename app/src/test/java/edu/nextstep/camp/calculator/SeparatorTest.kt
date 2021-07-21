package edu.nextstep.camp.calculator

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import org.junit.Test

class SeparatorTest {

    private val separator = Separator()

    @Test
    fun `수식에서 숫자들만 분리한다`() {
        //given
        val expression = "1+3-4"

        //when
        val numbers = separator.getNumbers(expression)

        //then
        assertThat(numbers).isEqualTo(listOf(Number(1), Number(3), Number(4)))
    }

    @Test
    fun `수식에서 기호들을 분리해준다`() {
        //given
        val expression = "1+3-4"

        //when
        val operators = separator.getOperators(expression)

        //then
        assertThat(operators).isEqualTo(listOf(Operator("+"), Operator("-")))
    }
}