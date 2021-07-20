package edu.nextstep.camp.calculator

import com.google.common.truth.Truth
import org.junit.Test

class CalculatorTest {

    @Test
    fun `6과 7을 plus함수로 더하면 13이 나와야 한다`() {
        val calculator = Calculator()
        val result = calculator.plus(6, 7)
        Truth.assertThat(result).isEqualTo(13)
    }


}
