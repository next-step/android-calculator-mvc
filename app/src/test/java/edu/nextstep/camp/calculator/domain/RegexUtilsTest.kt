package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class RegexUtilsTest {

    @Test
    fun checkInvalidExpressionStartingWithOperator() {
        assertThat(RegexUtils.checkExpressionIsValid("-1+10+11")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid("+12+10")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid("*12123+1")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid("/12123+1")).isEqualTo(false)
    }

    @Test
    fun checkValidExpressions() {
        assertThat(RegexUtils.checkExpressionIsValid("1+10+11")).isEqualTo(true)
        assertThat(RegexUtils.checkExpressionIsValid("1")).isEqualTo(true)
        assertThat(RegexUtils.checkExpressionIsValid("1/10+30110*11")).isEqualTo(true)
        assertThat(RegexUtils.checkExpressionIsValid("13/0+3123110*11")).isEqualTo(true)
    }

    @Test
    fun checkInvalidExpressions() {
        assertThat(RegexUtils.checkExpressionIsValid("-1++10+11")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid("null1+10+11")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid("-1**10/+11")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid("1+10+11sxx")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid("text")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid("")).isEqualTo(false)
        assertThat(RegexUtils.checkExpressionIsValid(" ")).isEqualTo(false)
    }
}
