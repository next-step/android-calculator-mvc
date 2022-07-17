package edu.nextstep.camp.calculator

import com.google.common.truth.Truth
import com.soolee.domain.util.CalculatorInputUtil
import org.junit.Test

class CalculatorInputUtilTest {
    @Test
    fun `숫자타입의_문자를_입력하면_TRUE를_반환한다`() {
        val actual: Boolean = CalculatorInputUtil.isNumberRegex("1")
        Truth.assertThat(actual).isEqualTo(true)
    }

    @Test
    fun `숫자타입이_아닌_문자를_입력하면_FALSE를_반환한다`() {
        val actual: Boolean = CalculatorInputUtil.isNumberRegex("r")
        Truth.assertThat(actual).isEqualTo(false)
    }

    @Test
    fun `연산자타입인_문자를_입력하면_TRUE를_반환한다`() {
        val actual: Boolean = CalculatorInputUtil.isOperationMarkRegex("+")
        Truth.assertThat(actual).isEqualTo(true)
    }

    @Test
    fun `연산자타입인_÷문자를_입력하면_TRUE를_반환한다`() {
        val actual: Boolean = CalculatorInputUtil.isOperationMarkRegex("÷")
        Truth.assertThat(actual).isEqualTo(true)
    }

    @Test
    fun `연산자타입인_-문자를_입력하면_TRUE를_반환한다`() {
        val actual: Boolean = CalculatorInputUtil.isOperationMarkRegex("-")
        Truth.assertThat(actual).isEqualTo(true)
    }

    @Test
    fun `연산자타입인_×문자를_입력하면_TRUE를_반환한다`() {
        val actual: Boolean = CalculatorInputUtil.isOperationMarkRegex("×")
        Truth.assertThat(actual).isEqualTo(true)
    }

    @Test
    fun `연산자타입이_아닌_문자를_입력하면_FALSE를_반환한다`() {
        val actual: Boolean = CalculatorInputUtil.isOperationMarkRegex("s")
        Truth.assertThat(actual).isEqualTo(false)
    }
}