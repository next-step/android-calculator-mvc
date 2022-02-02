package edu.nextstep.camp.domain

import edu.nextstep.camp.domain.exception.InvalidExpressionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorInterfaceTest {

    private val calculatorInterface = CalculatorInterface()

    @Test
    fun `입력된 수신이 완전할 때, 사용자가 = 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다`() {
        // given
        calculatorInterface.insert("3")
        calculatorInterface.insert("+")
        calculatorInterface.insert("2")

        // when
        val actual = calculatorInterface.evaluate()
        val expected = "5"

        // then
        assertThat(actual.getOrNull()).isEqualTo(expected)
    }

    @Test
    fun `입력된 수신이 완전하지 않을 때, 사용자가 = 버튼을 눌렀을 때 에러 결과가 반환 되어야 한다`() {
        // given
        calculatorInterface.insert("3")
        calculatorInterface.insert("+")

        //when
        val actualException =
            runCatching {
                calculatorInterface.evaluate()
            }.exceptionOrNull()

        //then
        assertThat(actualException).isInstanceOf(InvalidExpressionException::class.java)
    }
}