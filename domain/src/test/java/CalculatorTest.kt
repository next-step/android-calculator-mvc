package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.camp.calculator.Calculator
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `덧셈이 되어야 한다`() {
        
        // given
        val requestedValue = "11 +             222"
        val expectedValue = 233

        // when
        val actualValue = calculator.evaluate(requestedValue)
        
        //then
        assertThat(actualValue).isEqualTo(expectedValue)
        
    }

    @Test
    fun `뺄셈이 되어야 한다`() {
        //given
        val requestedValue = "11 -    222"
        val expectedValue = -211

        //when
        val actual = calculator.evaluate(requestedValue)

        //then
        assertThat(actual).isEqualTo(expectedValue)
    }

    @Test
    fun `나눗셈이 되어야 한다`() {
        //given
        val requestedValue = "222 /    2 / 111"
        val expectedValue = 1

        //when
        val actual = calculator.evaluate(requestedValue)

        //then
        assertThat(actual).isEqualTo(expectedValue)
    }

    @Test
    fun `곱셈이 되어야 한다`() {
        //given
        val requestedValue = "222 *    2 * 3"
        val expectedValue = 1332

        //when
        val actual = calculator.evaluate(requestedValue)

        //then
        assertThat(actual).isEqualTo(expectedValue)
    }

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException throw`() {
        
        // given
        val requestedValue = null
        val expectedInstance = IllegalArgumentException::class.java

        // when
        val actualValue = runCatching {
            calculator.evaluate(requestedValue)
        }.exceptionOrNull()

        // then
        assertThat(actualValue).isInstanceOf(expectedInstance)

    }

    @Test
    fun `입력값이 공백일 경우 IllegalArgumentException throw`() {
        
        // given
        val requestedValue = " "
        val expectedInstance = IllegalArgumentException::class.java
        
        // when
        val actualValue = runCatching { 
            calculator.evaluate(requestedValue)
        }.exceptionOrNull()
        
        // then
        assertThat(actualValue).isInstanceOf(expectedInstance)
        assertThat(actualValue?.message?.startsWith("not valid inputValue")).isTrue()
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        //given
        val requestedValue = "121  % 222"
        val expectedInstance = IllegalArgumentException::class.java

        //when
        val actualValue = runCatching {
            calculator.evaluate(requestedValue)
        }.exceptionOrNull()

        //then
        assertThat(actualValue).isInstanceOf(expectedInstance)
        assertThat(actualValue?.message).isEqualTo("not valid operator included.")
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현`() {
        //given
        val requestedValue = "2 + 3 * 4 / 2"
        val expectedValue = 10

        //when
        val actual = calculator.evaluate(requestedValue)

        //then
        assertThat(actual).isEqualTo(expectedValue)
    }
}