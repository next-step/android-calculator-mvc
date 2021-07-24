package edu.nextstep.camp.domain.stringcalculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created By Malibin
 * on 7월 22, 2021
 */

class StringTokensTest {

    @Test
    fun `문자열을 넣으면 공백 단위로 잘라 리스트로 반환한다`() {
        // given
        val string = "1 + 2"
        val expectedTokens = listOf("1", "+", "2")

        // when
        val actualTokens = StringTokens.from(string)

        // then
        assertThat(actualTokens).isEqualTo(expectedTokens)
    }

    @Test
    fun `문자열 양 끝에 white spaces가 있어도 공백 단위로 문자를 자른다`(){
        // given
        val string = "   1 + 2          "
        val expectedTokens = listOf("1", "+", "2")

        // when
        val actualTokens = StringTokens.from(string)

        // then
        assertThat(actualTokens).isEqualTo(expectedTokens)
    }
}
