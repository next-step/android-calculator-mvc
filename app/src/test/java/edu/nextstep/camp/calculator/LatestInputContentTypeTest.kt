package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LatestInputContentTypeTest {

    @Test
    fun getLatestInputContentTypeWhenContentsEmpty() {
        //given
        val contents = ""

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contents)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.NONE)
    }

    @Test
    fun getLatestInputContentTypeWhenLatestContentIsNumber() {
        //given
        val contents = "1 + 2"

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contents)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.NUMBER)
    }

    @Test
    fun getLatestInputContentTypeWhenLatestContentIsOperator() {
        //given
        val contents = "1 + 2 - "

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contents)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.OPERATOR)
    }
}
