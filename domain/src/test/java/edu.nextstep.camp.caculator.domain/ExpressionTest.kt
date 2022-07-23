package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class ExpressionTest {
    lateinit var expression: Expression
    @Before
    fun init(){
        expression = Expression()
    }

    @Test
    fun `계산기에_1+2를_입력하면_("1 + 2")의_문자열이_나온다`() {
        expression.addNumber("1")
        expression.addOperator("+")
        expression.addNumber("2")
        var actual = expression.express
        Truth.assertThat(actual).isEqualTo("1 + 2")
    }

    @Test
    fun `계산기에_공백이_포함된_1+ 2를_입력하면_("1 + 2")의_문자열을_express에_저장한다`() {
        expression.addNumber("1")
        expression.addOperator("+")
        expression.addNumber(" ")
        expression.addNumber("2")
        var actual = expression.express
        Truth.assertThat(actual).isEqualTo("1 + 2")
    }

    @Test
    fun `계산기에_32+3를_입력하면_("32 + 3")의_문자열을_express에_저장한다`() {
        expression.addNumber("3")
        expression.addNumber("2")
        expression.addOperator("+")
        expression.addNumber("3")
        var actual = expression.express
        Truth.assertThat(actual).isEqualTo("32 + 3")
    }
}