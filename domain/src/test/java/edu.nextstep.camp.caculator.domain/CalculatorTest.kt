package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    //해피케이스
    @Test
    fun `숫자를_더해준다`() {
        val actual: Int = Calculator.calculate(listOf("3", "+", "3"))
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `숫자를_빼준다`() {
        val actual: Int = Calculator.calculate(
            listOf("3", "-", "3")
        )
        assertThat(actual).isEqualTo(0)
    }

    @Test
    fun `숫자를_곱해준다`() {
        val actual: Int =
            Calculator.calculate(listOf("3", "×", "2"))
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `숫자를_나눠준다`() {
        val actual: Int =
            Calculator.calculate(listOf("18", "÷", "3"))
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `입력된_순서대로_숫자를_연산해준다`() {
        val actual: Int =
            Calculator.calculate(listOf("18", "÷", "3", "×", "2"))
        assertThat(actual).isEqualTo(12)
    }

    //언해피케이스×÷+
    @Test
    fun `빈칸을_입력하면_빈칸을_빼고_계산한다`() {
        val actual: Int =
            Calculator.calculate(
                listOf("1", " ", "+", "2", "+", "3")
            )
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `마지막에_연산자를_입력하면_마지막_연산은_무시한다`() {
        val actual: Int = Calculator.calculate(listOf("1", "+", "2", "+", "3", "-"))
        assertThat(actual).isEqualTo(6)
    }
}