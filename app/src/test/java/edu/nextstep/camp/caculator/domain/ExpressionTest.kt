package edu.nextstep.camp.caculator.domain

import org.junit.Test

class ExpressionTest {

    @Test(expected = IllegalArgumentException::class)
    fun validateExpression1() {
        // When
        Expression("     ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun validateExpression2() {
        // When
        Expression("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun validateExpression3() {
        // When
        Expression("test")
    }
}