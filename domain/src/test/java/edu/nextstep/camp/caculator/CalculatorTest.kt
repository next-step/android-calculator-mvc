package edu.nextstep.camp.caculator

import com.google.common.truth.Truth.*
import edu.nextstep.camp.caculator.domain.Calculator
import edu.nextstep.camp.caculator.domain.Expression
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun 연산자_테스트() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("+")
        expression.addExpression("2")
        expression.addExpression("-")
        expression.addExpression("2")
        expression.addExpression("*")
        expression.addExpression("2")
        expression.addExpression("/")
        expression.addExpression("2")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun 양수_결과_테스트() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("3")
        expression.addExpression("-")
        expression.addExpression("3")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(20)
    }

    @Test
    fun 음수_결과_테스트() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("-")
        expression.addExpression("9")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(-7)
    }
}