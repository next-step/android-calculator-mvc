package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    @Test
    fun `2 더하기 3 곱하기 4 나누기 2의 연산의 결과는 10이 되어야한다`() {

        // given
        val operationExpression = "2+3*4/2"
        // when
        val result = Calculator.calculate(operationExpression)
        // then
        assertThat(result).isEqualTo(10.0)
    }

}
