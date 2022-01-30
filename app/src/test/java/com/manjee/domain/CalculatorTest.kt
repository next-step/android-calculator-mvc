package com.manjee.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `123+123=246`() {
        assertThat(calculator.calculate("123 + 123")).isEqualTo(246)
    }

    @Test
    fun `수식이 완전하지 않을시 IllegalArgumentException 발생`() {
        // given
        val expression = "2 * "

        // when
        val actualException = runCatching { calculator.calculate(expression) }.exceptionOrNull()

        // then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat().contains("완전하지 않은 수식입니다")
    }

    @Test
    fun `사칙연산이 아닌 연산자 입력시 IllegalArgumentException 발생`() {
        // given
        val expression = "2 & 0"

        // when
        val actualException = runCatching { calculator.calculate(expression) }.exceptionOrNull()

        // then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat().contains("허용하지 않는 연산자입니다")
    }

    @Test
    fun `0으로 나누면 IllegalArgumentException 발생`() {
        // given
        val expression = "2 / 0"

        // when
        val actualException = runCatching { calculator.calculate(expression ) }.exceptionOrNull()

        // then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat().contains("값을 0으로 나눌 수 없음")
    }

    @Test
    fun `입력 값이 null이면 IllegalArgumentException 발생`() {
        // given
        val expression = null

        // when
        val actualException = runCatching { calculator.calculate(expression ) }.exceptionOrNull()

        // then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat().contains("입력 값은 null 이거나 비어있을 수 없습니다")
    }

    @Test
    fun `입력 값이 공백이면 IllegalArgumentException 발생`() {
        // given
        val expression = ""

        // when
        val actualException = runCatching { calculator.calculate(expression ) }.exceptionOrNull()

        // then
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat().contains("입력 값은 null 이거나 비어있을 수 없습니다")
    }
}