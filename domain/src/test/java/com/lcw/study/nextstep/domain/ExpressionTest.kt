package com.lcw.study.nextstep.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {

    @Test
    @DisplayName("8이 입력되어 있을 때 9를 입력하면 89가 되어야 한다")
    internal fun test1() {
        // given
        var expression = Expression("8")

        //when
        expression += 9
        val actual = expression.rawExpression

        //then
        assertThat(actual).isEqualTo("89")
    }

    @ValueSource(strings = ["+", "-", "*", "/"])
    @ParameterizedTest(name = "입력된 피연산자가 없을 때 연산자를 입력하면 변화가 없어야 한다")
    internal fun test2(rawOperator: String) {
        // given
        var expression = Expression.EMPTY

        //when
        expression += rawOperator
        val actual = expression

        //then
        assertThat(actual).isEqualTo(Expression.EMPTY)
    }

    @CsvSource(
        "3, +, 3 +",
        "3, -, 3 -",
        "3, *, 3 *",
        "3, /, 3 /",
    )
    @ParameterizedTest(name = "{0} 있을때, 연산자 {1}을 추가하면 수식은 {2} 이 되어야 한다")
    internal fun test3(rawExpression: String, rawOperator: String, expected: String) {
        //given
        var expression = Expression(rawExpression)

        //when
        expression += rawOperator
        val actual = expression.rawExpression

        //then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    @DisplayName("비어있을 때, 마지막을 제거하면 비어있어야 한다")
    internal fun test4() {
        //given
        var expression = Expression.EMPTY

        //when
        val actual = expression.dropLast()

        //then
        assertThat(actual).isEqualTo(Expression.EMPTY)
    }

    @CsvSource(
        "13,1",
        "22 +,22"
    )
    @ParameterizedTest(name = "{0} 일 때, 마지막을 제거하면 수식은 {1} 이어야 한다")
    internal fun test5(rawExpression: String, expected: String) {
        //given
        var expression = Expression(rawExpression)

        //when
        val actual = expression.dropLast().rawExpression

        //then
        assertThat(actual).isEqualTo(expected)
    }
}