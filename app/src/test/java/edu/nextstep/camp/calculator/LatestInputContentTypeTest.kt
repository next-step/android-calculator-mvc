package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LatestInputContentTypeTest {

    @Test
    fun getLatestInputContentType_WhenContentsEmpty() {
        //given
        val contents = ""

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contents)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.NONE)
    }

    @Test
    fun getLatestInputContentType_WhenLatestContentIsNumber() {
        //given
        val contents = "1 + 2"

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contents)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.NUMBER)
    }

    @Test
    fun getLatestInputContentType_WhenLatestContentIsOperator() {
        //given
        val contents = "1 + 2 - "

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contents)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.OPERATOR)
    }


    @Test
    fun getLatestInputContentLength_whenContentsAreEmpty() {
        //given
        val contents = ""

        //when
        val result = LatestInputContentType.getLatestInputContentLength(contents)

        //then
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun getLatestInputContentLength_whenLastContentIsNumber() {
        //given
        val contents = "1 + 3"

        //when
        val result = LatestInputContentType.getLatestInputContentLength(contents)

        //then
        assertThat(result).isEqualTo(LatestInputContentType.LENGTH_NUMBER_CONTENT)
    }

    @Test
    fun getLatestInputContentLength_whenLastContentIsOperator() {
        //given
        val contents = "1 + 3 - "

        //when
        val result = LatestInputContentType.getLatestInputContentLength(contents)

        //then
        assertThat(result).isEqualTo(LatestInputContentType.LENGTH_OPERATOR_CONTENT)
    }
}
