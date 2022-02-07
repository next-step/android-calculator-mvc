package com.example.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class ExpressionTest {

    private lateinit var expression: Expression

    @BeforeEach
    fun setUp() {
        expression = Expression.empty()
    }

    @ValueSource(
        strings = [
            "1", "2", "3", "4", "5", "6", "7", "8", "9",
        ]
    )
    @ParameterizedTest(name = "{0}을 {0}보여준다.")
    fun test1(input: String) {
        expression += input
        val express = expression.express(Calculator())
        assertThat(express.value).isEqualTo(input)
    }

    @CsvSource(
        value = [
            "1,2,12",
            "8,9,89",
        ]
    )
    @ParameterizedTest(name = "입력된 {0} 피연산자가 있을 때, {1} 입력하면 화면에 {2} 보여야 한다.")
    fun test2(input1: String, input2: String, expected: String) {
        expression += input1
        expression += input2
        assertThat(expression.value).isEqualTo(expected)
    }

    @CsvSource(
        value = [
            "8,+,4,12",
            "8,-,4,4",
            "8,*,4,32",
            "8,/,4,2",
        ]
    )
    @ParameterizedTest(name = "완전한 수식 {0} {1} {2} 입력하면 화면에 {3} 보여야 한다.")
    fun test3(operator1: String, operand: String, operator2: String, expected: String) {
        expression += operator1
        expression += Operand.get(operand)!!
        expression += operator2
        val actual = expression.express(Calculator())
        assertThat(actual.value).isEqualTo(expected)
    }
}