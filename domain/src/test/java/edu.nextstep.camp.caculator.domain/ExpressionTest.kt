package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class ExpressionTest {
    @Before
    fun init(){
    }

    @Test
    fun `계산기에_1+2를_입력하면_("1 + 2")의_문자열이_나온다`() {
        Expression.addNumber("1")
        Expression.addOperator("+")
        Expression.addNumber("2")
        var actual = Expression.express
        Truth.assertThat(actual).isEqualTo("1 + 2")
    }

    @Test
    fun `계산기에_공백이_포함된_1+ 2를_입력하면_("1 + 2")의_문자열을_express에_저장한다`() {
        Expression.addNumber("1")
        Expression.addOperator("+")
        Expression.addNumber(" ")
        Expression.addNumber("2")
        var actual = Expression.express
        Truth.assertThat(actual).isEqualTo("1 + 2")
    }

    @Test
    fun `계산기에_32+3를_입력하면_("32 + 3")의_문자열을_express에_저장한다`() {
        Expression.addNumber("3")
        Expression.addNumber("2")
        Expression.addOperator("+")
        Expression.addNumber("3")
        var actual = Expression.express
        Truth.assertThat(actual).isEqualTo("32 + 3")
    }
}