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

    // 덧셈이 되어야 한다.
    @Test
    fun add() {
        
        // given
        val requestedValue = "11 +             222"
        val expectedValue = 233

        // when
        val actualValue = calculator.evaluate(requestedValue)
        
        //then
        assertThat(actualValue).isEqualTo(expectedValue)
        
    }

    // 뺄셈이 되어야 한다.
    @Test
    fun minus() {
        //given
        val requestedValue = "11 -    222"
        val expectedValue = -211

        //when
        val actual = calculator.evaluate(requestedValue)

        //then
        assertThat(actual).isEqualTo(expectedValue)
    }

    // 나눗셈이 되어야 한다.
    @Test
    fun divide() {
        //given
        val requestedValue = "222 /    2 / 111"
        val expectedValue = 1

        //when
        val actual = calculator.evaluate(requestedValue)

        //then
        assertThat(actual).isEqualTo(expectedValue)
    }

    // 곱셈이 되어야 한다.
    @Test
    fun multiply() {
        //given
        val requestedValue = "222 *    2 * 3"
        val expectedValue = 1332

        //when
        val actual = calculator.evaluate(requestedValue)

        //then
        assertThat(actual).isEqualTo(expectedValue)
    }

    // 입력값이 null일 경우 IllegalArgumentException throw!
    @Test
    fun nullCheck() {
        
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

    // 입력값이 공백일 경우 IllegalArgumentException throw!
    @Test
    fun blankCheck() {
        
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

    // 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    @Test
    fun operationSignCheck() {
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
    fun containsAllOperation() {
        //given
        val requestedValue = "2 + 3 * 4 / 2"
        val expectedValue = 10

        //when
        val actual = calculator.evaluate(requestedValue)

        //then
        assertThat(actual).isEqualTo(expectedValue)
    }
}