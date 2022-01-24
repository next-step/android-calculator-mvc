package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.exception.InvalidExpressionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CalculatorInterfaceTest {

    private val calculatorInterface = CalculatorInterface()

    @DisplayName("3 + 2 -> = 클릭 -> 5")
    @Test
    fun `입력된 수신이 완전할 때, 사용자가 = 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다`() {
        // given
        calculatorInterface.insert("3")
        calculatorInterface.insert("+")
        calculatorInterface.insert("2")

        // when
        val actual = calculatorInterface.evaluate()

        // then
        assertThat(actual.getOrNull()).isEqualTo("5")
    }

    @DisplayName("3 + -> = 클릭 -> 에러 결과 반환")
    @Test
    fun `입력된 수신이 완전하지 않을 때, 사용자가 = 버튼을 눌렀을 때 에러 결과가 반환 되어야 한다`() {
        // given
        calculatorInterface.insert("3")
        calculatorInterface.insert("+")

        // when
        val actual = calculatorInterface.evaluate()

        // then
        assertThat(actual.exceptionOrNull()).isInstanceOf(InvalidExpressionException::class.java)
    }
}