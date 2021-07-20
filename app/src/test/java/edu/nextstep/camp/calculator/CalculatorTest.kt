package edu.nextstep.camp.calculator

import com.google.common.truth.Truth
import org.junit.Test

class CalculatorTest {

    @Test
    fun `number1과 number2를 더한 값은 4이다`() {
        val calculator = Calculator()
        val result = calculator.plus(6, 7)
        Truth.assertThat(result).isEqualTo(13)
    }
}
