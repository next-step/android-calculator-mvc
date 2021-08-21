package edu.nextstep.camp.calculator.model

import org.assertj.core.api.Assertions
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class CalculatorTest {
    @Test
    fun `문자열계산식 없을 때 예외발생`() {
        Assertions.assertThatThrownBy { Calculator("").splitText() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("문자열 계산을 할 수 없습니다.")
    }

    @Test
    fun `문자열계산식 없을 때 숫자가 없을 때 예외발생`() {
        Assertions.assertThatThrownBy { Calculator("? + 2").splitText() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자를 입력해주세요.")
    }

    @Test
    fun `문자열계산식 없을 때 연산자가 아닐 때 예외발생`() {
        Assertions.assertThatThrownBy { Calculator("2 # 4").splitText() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("올바른 연산자 부호를 입력해주세요.")
    }

    @Test
    fun `띄어쓰기문자를 배열로 담을 수 있다`() {
        //when
        var input = Calculator("2 + 3")
        var inputs = input.splitText()

        //then
        assertEquals(inputs.size, 3)
    }

    @ParameterizedTest
    @ValueSource(strings=["2 + 3", "7 - 2", "1 * 5", "10 / 2"])
    fun `배열이 세개일 때 사칙연산을 해야한다`(resultCalculated: String) {
        var input = Calculator(resultCalculated)
        assertThat(input.calculate(), equalTo(5.0))
    }

    @ParameterizedTest
    @ValueSource(strings=["2 + 3 + 5", "13 - 2 - 1", "1 * 5 * 2", "20 / 2 / 1"])
    fun `배열이 다섯 개일 때 사칙연산을 해야한다`(resultCalculated: String) {
        var input = Calculator(resultCalculated)
        assertThat(input.calculate(), equalTo(10.0))
    }

    @Test
    fun `사칙연산`() {
        var input = Calculator("2 + 3 * 4 / 2")
        assertThat(input.calculate(), equalTo(10.0))
    }
}